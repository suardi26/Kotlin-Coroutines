package coroutine.scope

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    @Test
    fun testScope(){
        // Membuat coroutine scope baru dengan menggunakan function CoroutineScope dimana parameternya
        // context: CoroutineContext, bisa berupa Job(), atau Dispatchers.
        val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // Membuat coroutine pertama
        coroutineScope.launch {
            delay(1_000)
            println("Run ${Thread.currentThread().name}")
        }

        // Membuat coroutine kedua
        coroutineScope.launch {
            delay(1_000)
            println("Run ${Thread.currentThread().name}")
        }

        runBlocking {
            // menunggu semua process pada Coroutines selesai dieksekusi.
            delay(2_000)
            println("Done")
        }

    }

    @Test
    fun testScopeCancel(){
        // Membuat coroutine scope baru dengan menggunakan function CoroutineScope dimana parameternya
        // context: CoroutineContext, bisa berupa Job(), atau Dispatchers.
        val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // Membuat coroutine pertama
        coroutineScope.launch {
            delay(2_000)
            println("Run ${Thread.currentThread().name}")
        }

        // Membuat coroutine kedua
        coroutineScope.launch {
            delay(2_000)
            println("Run ${Thread.currentThread().name}")
        }

        runBlocking {

            delay(1_000)

            // membatalkan coroutine scope.
            // ketika membatalkan coroutine scope maka semua coroutine yang ada pada scope yang sama akan otomatis
            // dibatalkan.

            coroutineScope.cancel()
            delay(2_000)
            println("Done")
        }


    }
}