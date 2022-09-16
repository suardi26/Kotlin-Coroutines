package non.cancellable.context

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineDispatchersTest {

    @Test
    fun testCancelFinally(){
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Start Job")
                    delay(1_000)
                    println("End Job")
                }finally {
                    // karena sudah dibatalkan maka hasilnya false, dan function delay akan melakukan cek terhadap Job
                    // apakah active atau tidak dan ketika tidak aktif (false) maka akan throw cancellationException
                    // sehingga eksekusinya dibatalkan dan code program selanjutnya tidak dieksekusi.
                    println(isActive)
                    delay(1_000)
                    println("Finally") // tidak dieksekusi.
                }
            }
            job.cancelAndJoin()
        }
    }

    @Test
    fun testNonCancellable(){
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Start Job")
                    delay(1_000)
                    println("End Job")
                }finally {
                    // ketika menggunakan function withContext dan parameternya adalah NonCancellable (mengganti
                    // context-nya), menjadi NonCancellable maka didalam NonCancellable, dioverride properties isActive
                    // dan selalu mengembalikan nilai boolean true
                    // sehingga programnya tetap akan dilanjutkan meskipun telah di cancel.
                    withContext(NonCancellable){
                        println(isActive)
                        delay(1_000)
                        println("Finally") // akan dieksekusi.
                    }
                }
            }
            job.cancelAndJoin()
        }

    }
}