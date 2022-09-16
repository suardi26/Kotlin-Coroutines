package timeout

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class CancellableCoroutineTest {

    @Test
    fun testTimeOut(){
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Start Coroutine ")
                withTimeout(5_000){
                    // membuat perulangan sebanyak 100 kali, dimana setiap perulangan akan menunggu 1 detik, sehingga
                    // process dari coroutine adalah 100 detik (1 menit 40 detik), akan tetapi ada function
                    // withTime() yang diset 5 menit sehingga ketika coroutine berjalan diatas 5 menit akan Throw
                    // TimeoutCancellationException (dibatalkan).
                    repeat(100){
                        delay(1_000)
                        println("$it ${Date()}")
                    }
                }
                println("Finish Coroutine ")
            }
            // menunggu coroutine selesai melakukan process.
            job.join()
        }
    }

    @Test
    fun testTimeoutOrNull(){
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Start Coroutine ")
                withTimeoutOrNull(5_000){
                    // membuat perulangan sebanyak 100 kali, dimana setiap perulangan akan menunggu 1 detik, sehingga
                    // process dari coroutine adalah 100 detik (1 menit 40 detik), akan tetapi ada function
                    // withTime() yang diset 5 menit sehingga ketika coroutine berjalan diatas 5 menit akan Throw
                    // TimeoutCancellationException (dibatalkan).
                    repeat(100){
                        delay(1_000)
                        println("$it ${Date()}")
                    }
                }
                // Tetap dieksekusi karena function withTimeoutOrNull() tidak throw exception.
                println("Finish Coroutine ")
            }
            // menunggu coroutine selesai melakukan process.
            job.join()
        }
    }
}