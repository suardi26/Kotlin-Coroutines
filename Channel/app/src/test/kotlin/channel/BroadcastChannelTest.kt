package channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.broadcast
import org.junit.jupiter.api.Test

class BroadcastChannelTest {

    @Test
    fun testBroadcastChannel(){

        // Membuat object BroadcastChannel
        val broadcastChannel: BroadcastChannel<Int> = BroadcastChannel<Int>(capacity = 10)

        // Membuat beberapa receiver untuk coroutine, jadi masing-masing coroutine memilki receiver sendiri
        // ketika ingin membuat 2 coroutine untuk menerima data, maka receiver-nya juga harus 2.
        val receiveChannel1: ReceiveChannel<Int> = broadcastChannel.openSubscription()
        val receiveChannel2: ReceiveChannel<Int> = broadcastChannel.openSubscription()

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val jobSend = scope.launch {
            repeat(10){ counter ->
                broadcastChannel.send(counter)
            }
        }

        val job1 = scope.launch {
            repeat(10) {
                println("Job 1 ${receiveChannel1.receive()}")

            }
        }

        val job2 = scope.launch {
            repeat(10) {
                println("Job 2 ${receiveChannel2.receive()}")

            }
        }

        runBlocking {
            joinAll(job1, job2, jobSend)
        }
    }

    @Test
    fun testBroadcastFunction(){


        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // mengirim data menggunakan function Coroutine scope broadcast.
        val broadcastChannel = scope.broadcast<Int>(capacity = 10) {
            repeat(10){ counter ->
                send(counter)
            }
        }

        // Membuat beberapa receiver untuk coroutine, jadi masing-masing coroutine memilki receiver sendiri
        // ketika ingin membuat 2 coroutine untuk menerima data, maka receiver-nya juga harus 2.
        val receiveChannel1: ReceiveChannel<Int> = broadcastChannel.openSubscription()
        val receiveChannel2: ReceiveChannel<Int> = broadcastChannel.openSubscription()

        val job1 = scope.launch {
            repeat(10) {
                println("Job 1 ${receiveChannel1.receive()}")

            }
        }

        val job2 = scope.launch {
            repeat(10) {
                println("Job 2 ${receiveChannel2.receive()}")

            }
        }

        runBlocking {
            joinAll(job1, job2)
        }
    }

    @Test
    fun testConflatedBroadcastChannel(){
        val conflatedBroadcastChannel: ConflatedBroadcastChannel<Int> = ConflatedBroadcastChannel<Int>()
        val receiveChannel = conflatedBroadcastChannel.openSubscription()

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val job1 = scope.launch {
            repeat(10){
                delay(1_000)
                println("Send $it")
                conflatedBroadcastChannel.send(it)
            }
        }

        val job2 = scope.launch {
            repeat(10){
                // Karena pengiriman data pada coroutine job1 itu lebih cepat 1 detik sehingga nanti pengambilan
                // data pada ConflatedBroadcastChannel tidak utuh, hanya mengambil data paling baru saja.
                delay(2_000)
                println("Receive ${receiveChannel.receive()}")
            }
        }

        runBlocking {
            delay(11_000)
            scope.cancel()
            joinAll(job1, job2)
        }
    }
}