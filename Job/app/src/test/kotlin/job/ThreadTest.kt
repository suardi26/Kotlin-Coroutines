package job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*


class ThreadTest {

    @Test
    fun testJob() {

        // coroutine dapat juga dibuat dan di running pada runBlocking()
        runBlocking() {

            // blocking tidak akan menunggu coroutine
            // artinya coroutine akan jalan sendiri dan yang akan di block yaitu kode-kode yang bukan coroutine,
            // contohnya delay.
            GlobalScope.launch {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }
        }
    }

    @Test
    fun testJobLazy() {

        // coroutine dapat juga dibuat dan di running pada runBlocking()
        runBlocking() {

            // blocking tidak akan menunggu coroutine
            // artinya coroutine akan jalan sendiri dan yang akan di block yaitu kode-kode yang bukan coroutine,
            // contohnya delay.
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            // menjalankan coroutine secara manual menggunakan Job yang merupakan representasi dari
            // object Coroutine. Namun pada saat dijalankan maka akan jalan secara Asyncron...
            // (Langsung jalan secara concurrency).
            job.start()
            delay(3_000)


        }
    }

    @Test
    fun testJobJoin() {

        // coroutine dapat juga dibuat dan di running pada runBlocking()
        runBlocking() {

            // blocking tidak akan menunggu coroutine
            // artinya coroutine akan jalan sendiri dan yang akan di block yaitu kode-kode yang bukan coroutine,
            // contohnya delay.
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            // menjalankan coroutine secara manual menggunakan Job yang merupakan representasi dari
            // object Coroutine. Namun pada saat dijalankan maka akan jalan secara Asyncron...
            // (Langsung jalan secara concurrency).
            job.start()

            // menunggu coroutine sampai dia selesai tanpa menggunakan functin delay() lagi.
            job.join()


        }
    }

    @Test
    fun testJobCancel() {

        // coroutine dapat juga dibuat dan di running pada runBlocking()
        runBlocking() {

            // blocking tidak akan menunggu coroutine
            // artinya coroutine akan jalan sendiri dan yang akan di block yaitu kode-kode yang bukan coroutine,
            // contohnya delay.
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            // menjalankan coroutine secara manual menggunakan Job yang merupakan representasi dari
            // object Coroutine. Namun pada saat dijalankan maka akan jalan secara Asyncron...
            // (Langsung jalan secara concurrency).
            job.start()

            // untuk membatalkan coroutine menggunakan object dari Job.
            job.cancel()

            delay(3_000)
        }
    }
}