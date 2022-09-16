package cancellable.coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class CancellableCoroutineTest {
    @Test
    fun testCanNotCancel(){
        runBlocking {
            val job = GlobalScope.launch {
                println("Start Coroutine ${Date()}")

                // kode yang tidak dapat dibatalkan
                Thread.sleep(2_000)

                println("End Coroutine ${Date()}")
            }

            job.cancel()
            delay(3_000)
        }
    }

    @Test
    fun testCanCancel(){
        runBlocking {
            val job = GlobalScope.launch {

                // melakukan pengecekan apakah coroutine masih aktif sebelum kode program dieksekusi tiap barisnya.
                if (!isActive) throw CancellationException()
                println("Start Coroutine ${Date()}")

                // melakukan pengecekan apakah coroutine masih aktif dengan menggunakan function yang disediakan oleh
                // kotlin yaitu ensureActive().
                ensureActive()
                Thread.sleep(2_000)

                ensureActive()
                println("End Coroutine ${Date()}")

                // ket : pada saat membuat program nanti nya tidak usah melakukan pengecekan tiap barisnya melainkan
                // per block code saja.

            }

            job.cancel()
            delay(3_000)
        }
    }

    @Test
    fun testCancellableFinally(){
        runBlocking {
            val job = GlobalScope.launch {
               try {
                   println("Start Coroutine ${Date()}")

                   // delay dapat dibatalkan
                   delay(2_000)

                   println("End Coroutine ${Date()}")

               } finally {
                   println("Finish")
               }
            }
            // Melakukan cancel coroutine dan menunggu coroutine sampai dia selesai.
            job.cancelAndJoin()

        }
    }

}