package yield.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SequentialSuspendFunctionTest {

    suspend fun runJob(number: Int){
        println("Start Job $number in Thread ${Thread.currentThread().name}")

        // Menggunakan function yield()
        // yang berfungsi untuk memberi kesempatan Thread(Dispatcher) yang digunakan oleh coroutine dispatcher saat ini
        // ke coroutine yang lain jika memungkinkan.
        yield()
        println("End Job $number in Thread ${Thread.currentThread().name}")
    }
    @Test
    fun testYieldFunction(){
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        runBlocking {
            scope.launch {
                runJob(1)
                runJob(2)

                delay(2_000)
            }
        }
    }
}