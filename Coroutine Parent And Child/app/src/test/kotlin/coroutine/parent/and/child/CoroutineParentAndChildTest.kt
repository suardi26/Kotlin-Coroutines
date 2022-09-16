package coroutine.parent.and.child

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineParentAndChildTest {
    @Test
    fun testParentChild(){
        runBlocking {
            // membuat coroutine parent.
            val job = GlobalScope.launch {

                // membuat coroutine child.
                launch {
                    delay(2_000)
                    println("Child 1")
                }
                // membuat coroutine child.
                launch {
                    delay(2_000)
                    println("Child 2")
                }
                delay(1_000)
                println("Parent Finish")
            }
            // Menunggu eksekusi dari coroutine parent
            // dan coroutine parent akan menunggu semua eksekusi dari coroutine child-nya, baru dapat selesai.
            job.join()
        }
    }
}