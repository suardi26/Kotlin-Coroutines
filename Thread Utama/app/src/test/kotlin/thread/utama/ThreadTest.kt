package thread.utama

import org.junit.jupiter.api.Test

class ThreadTest {
    @Test
    fun testMainThread(){

        val threadName = Thread.currentThread().name
        println(threadName)
    }
}