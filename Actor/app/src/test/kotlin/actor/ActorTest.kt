package actor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ActorTest {

    @Test
    fun testActor(){
        val scope = CoroutineScope(Dispatchers.IO)

        // menggunakan function Coroutine scope actor dan return value-nya adalah SendChannel.
        val sendChannel: SendChannel<Int> = scope.actor<Int>(capacity = 10) {
            repeat(10){
                println("Actor receive data ${receive()}")
            }
        }

        val job = scope.launch {
            repeat(10){
                sendChannel.send(it)
            }
        }

        runBlocking {
            job.join()
        }
    }
}