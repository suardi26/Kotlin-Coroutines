package async.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AsyncTest {

    suspend fun getFoo(): Int {
        delay(1_000)
        return 10
    }

    suspend fun getBar(): Int{
        delay(1_000)
        return 10
    }

    @Test
    fun testAsync(){
        runBlocking {
            // Membuat coroutine yang mengembalikan data.
            val time: Long = measureTimeMillis {
                val foo : Deferred<Int> = GlobalScope.async { getFoo() }
                val bar : Deferred<Int> = GlobalScope.async { getBar() }

                // mengambil data Int-nya
                val result: Int = foo.await() + bar.await()
                println("Result $result")

            }
            println("Total Time $time") // total waktu 1 seconds
        }
    }
}