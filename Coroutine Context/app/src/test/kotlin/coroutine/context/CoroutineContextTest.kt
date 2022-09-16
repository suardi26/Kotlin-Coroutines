package coroutine.context

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class CoroutineContextTest {

    @ExperimentalStdlibApi
    @Test
    fun testCoroutineContext(){
        runBlocking {
            val job: Job = GlobalScope.launch {
                val context: CoroutineContext = coroutineContext
                println("CoroutineContext : $context")

                // mendapatkan object Job dari coroutineContext yang berisi kumpulan data yang salah satunya adalah Job.
                println("Object Job : ${context[Job]}")
                println("Dispatcher : ${context[CoroutineDispatcher]}")

                // Mengakses object Job dari element coroutineContext.
                val job: Job? = context[Job]
                job?.cancel()
            }
            job.join()
        }
    }

    @Test
    fun testCoroutineElements(){

        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Menggabungkan beberapa context element secara sekaligus, misal Dispatcher dan CoroutineName didalam
        // parameter CoroutineScope.
        val scope: CoroutineScope = CoroutineScope(dispatcher + CoroutineName("parent"))

        // Boleh juga menambahkan parameter CoroutineName("Coroutine1") di function launch(){...}
        // misal : scope.launch(CoroutineName("Coroutine1")) { ... }
        val job: Job = scope.launch {
            println("Parent run in thread ${Thread.currentThread().name}")
            withContext(CoroutineName("child") + Dispatchers.IO){
                println("Child run in thread ${Thread.currentThread().name}")
            }
        }

        runBlocking {
            job.join()
        }
    }
}