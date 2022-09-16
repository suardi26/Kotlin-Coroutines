package create.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*


class ThreadTest {

    // Membuat Coroutine dengan GlobalScope dengan method/function launch.
    @Test
    fun testCoroutine(){
        // merunning coroutine baru
        GlobalScope.launch {
            hello()
        }

        println("MENUNGGU")
        runBlocking {
            delay(2_000)
        }
        println("SELESAI")

    }

    suspend fun hello(){
        delay(1_000)
        println("hello word")
    }
}