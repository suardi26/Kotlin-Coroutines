package produce.function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.junit.jupiter.api.Test

class ProduceTest {

    @Test
    fun testSendElementManual(){
        // membuat scope
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // mengirim data secara manual pada object channel
            val channel: Channel<Int> = Channel<Int>()

            val job1 = scope.launch {
                repeat(100){ counter ->
                    channel.send(counter)
                }
            }

            val job2 = scope.launch {
                repeat(100){
                    println(channel.receive())
                }
            }

            runBlocking {
                joinAll(job1, job2)
            }
    }

    @Test
    fun testProduce(){
        // membuat scope
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // mengirim data menggunakan function Coroutine scope produce.
        val channel: ReceiveChannel<Int> = scope.produce {
            repeat(100){
                send(it)
            }
        }

            val job2 = scope.launch {
                repeat(100){
                    println(channel.receive())
                }
            }

            runBlocking {
                joinAll(job2)
            }
    }


}