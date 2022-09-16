package joinall.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class KotlinTest {

    @Test
    fun testJobJoinAll(){
        runBlocking {
            val job1: Job = GlobalScope.launch {
                delay(1_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }
            val job2: Job = GlobalScope.launch {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            // menunggu semua job selesai dengan function joinAll(varargs)
            joinAll(job1, job2)

        }
    }
}