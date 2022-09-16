package awaitall.function

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
    fun testAwaitAll(){
        runBlocking {
            // Membuat coroutine yang mengembalikan data.
            val time: Long = measureTimeMillis {
                val foo1 : Deferred<Int> = GlobalScope.async { getFoo() }
                val bar1 : Deferred<Int> = GlobalScope.async { getBar() }
                val foo2 : Deferred<Int> = GlobalScope.async { getFoo() }
                val bar2 : Deferred<Int> = GlobalScope.async { getBar() }

                // mengambil data Int-nya dengan function awaitAll() dan mengembalikan nilai List<T>.
                val result: Int = awaitAll(foo1, foo2, bar1, bar2).sum()
                println("Result $result")
            }
            println("Total Time $time") // total waktu 1 seconds
        }
    }
}