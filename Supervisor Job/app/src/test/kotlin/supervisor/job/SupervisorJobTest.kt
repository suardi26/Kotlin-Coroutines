package supervisor.job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SupervisorJobTest {
    @Test
    fun testJob(){
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Bisa begini
        // val scope: CoroutineScope = CoroutineScope(dispatcher + Job())
        // namun secara default dibuatkan Object Job()
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        val job1 = scope.launch {
            delay(2000)
            println("Job 1 Selesai")
        }

        val job2 = scope.launch {
            delay(1_000)
            throw IllegalArgumentException("Job 2 Gagal")
        }

        runBlocking {
            joinAll(job1, job2)
        }

        // maka job1 dan job2 tidak akan dieksekusi karena jika terjadi error pada salah satu coroutine maka dia
        // akan di propagate/dieskalasi pada parent-nya dan parent-nya akan membatalkan semua coroutine yang ada di
        // parent tersebut.
    }

    @Test
    fun testSupervisorJob(){
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope dengan Supervisor Job.
        val scope: CoroutineScope = CoroutineScope(dispatcher + SupervisorJob())

        val job1 = scope.launch {
            delay(2000)
            println("Job 1 Selesai")
        }

        val job2 = scope.launch {
            delay(1_000)
            throw IllegalArgumentException("Job 2 Gagal")
        }

        runBlocking {
            joinAll(job1, job2)
        }

        // Job1 tetap dieksekusi meskipun job2 mengalami error, hal ini karena menggunakan SupervisorJob yang
        // mengakibatkan coroutine memiliki kemampuan untuk error secara mandiri tanpa mempengaruhi coroutine lainnya.
    }
}