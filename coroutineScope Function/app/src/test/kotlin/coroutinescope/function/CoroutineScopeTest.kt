package coroutinescope.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    suspend fun getFoo(): Int{
        delay(100)
        println("Foo : ${Thread.currentThread().name}")
        return 10
    }

    suspend fun getBar(): Int{
        delay(1_000)
        println("Bar : ${Thread.currentThread().name}")
        return 10
    }

    suspend fun getSum(): Int {
        // Membuat Coroutine Scope menggunakan coroutineScope function
        // dan CoroutineContext-nya akan mengikuti dengan CoroutineContext yang memanggil-nya.
        return coroutineScope {
            val foo: Deferred<Int> = async {getFoo()}
            val bar: Deferred<Int> = async {getBar()}
            foo.await() + bar.await()
        }
    }

    suspend fun getSumManual(): Int{
        // Membuat Coroutine Scope secara manual
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val foo: Deferred<Int> = scope.async { getFoo() }
        val bar: Deferred<Int> = scope.async { getBar() }
        return foo.await() + bar.await()
    }

    @Test
    fun testCoroutineScopeFunction(){

        // scope dapat dipanggil dari coroutine scope yang lainnya.
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            val result = getSum()
            val resultManual = getSumManual()
            println("Result : $result")
            println("Result Manual: $resultManual")
        }

        runBlocking {
            job.join()
        }
    }
}