package cancelchildren.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineParentAndChildTest {

    @Test
    fun testParentChildCancel(){
        runBlocking {
            // membuat coroutine parent.
            val job = GlobalScope.launch {


                // membuat coroutine child.
                launch {
                    delay(2_000)
                    println("Child 1 Done")
                }
                // membuat coroutine child.
                launch {
                    delay(2_000)
                    println("Child 2 Done")
                }
                delay(1_000)
                println("Parent Done")
            }

            // membatalkan semua coroutine children.
            job.cancelChildren()
            job.join()
        }
    }
}