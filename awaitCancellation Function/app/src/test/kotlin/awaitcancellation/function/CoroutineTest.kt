package awaitcancellation.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineTest {

    @Test
    fun testAwaitCancellation(){
        runBlocking {
            // didalam runBlocking terdapat coroutineScope yang bernama BlockingCoroutine
            // sehingga tidak memerlukan coroutineScope lagi dan dapat langsung launch().
            val job = launch {
                try {
                    println("Job Start")

                    // function ini berguna untuk menunggu object coroutine-nya(Job) di cancel sehingga coroutine-nya
                    // dapat dibatalkan.
                    // dibatalkan ketika object coroutine-nya(Job) di cancel sehingga harus menunggu 5 detik sesuai delay
                    // dibawah kemudian baru di cancel, dan akhirnya coroutine-nya di batalkan.
                    awaitCancellation()
                }finally {
                    println("Cancelled")
                }
            }

            delay(5_000)
            job.cancelAndJoin()
        }
    }
}