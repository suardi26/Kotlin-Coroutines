package create.coroutine.dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class KotlinDispatchersTest {

    @Test
    fun testExecutorService(){

        // Membuat Coroutine dispatcher dengan cara menggunakan ExecutorService dan dikonversi menjadi Coroutine Dispatcher.
        val dispatcherService: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val dispatcherWeb: ExecutorCoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

        runBlocking {

            // menggunakan Coroutine Dispatcher yang dibuat.
            val job1: Job = GlobalScope.launch(dispatcherService) {
                println("Job 1 : ${Thread.currentThread().name}")
            }
            val job2: Job = GlobalScope.launch(dispatcherWeb){
                println("Job 2 : ${Thread.currentThread().name}")
            }
            joinAll(job1, job2)
        }
    }
}