package withcontext.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class CoroutineDispatchersTest {

    @Test
    fun testWithContext(){

        // Membuat Coroutine dispatcher dengan cara menggunakan ExecutorService dan dikonversi menjadi Coroutine Dispatcher.
        val dispatcherClient: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        runBlocking {
            val job1: Job = GlobalScope.launch(Dispatchers.IO) {
                println("1 ${Thread.currentThread().name}")

                // menggunakan Coroutine Dispatcher yang dibuat dan mengganti thread di tengah baris program.
                withContext(dispatcherClient){
                    println("2 ${Thread.currentThread().name}")
                }

                println("3 ${Thread.currentThread().name}")

                // menggunakan Coroutine Dispatcher yang dibuat dan mengganti thread di tengah baris program.
                withContext(dispatcherClient){
                    println("4 ${Thread.currentThread().name}")
                }

            }
            job1.join()
        }
    }
}