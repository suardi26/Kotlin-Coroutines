package select.function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

class SelectTest {
    @Test
    fun testSelectDeferred(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val deferred1: Deferred<Int> = scope.async {
            delay(1_000)
            1_000
        }

        val deferred2: Deferred<Int> = scope.async {
            delay(2_000)
            2_000
        }

        val deferred3: Deferred<Int> = scope.async {
            delay(3_000)
            3_000
        }

        val job = scope.launch {
            val win: String = select<String>{
                // mencari coroutine mana yang paling cepat selesai.
                deferred1.onAwait{value -> "Result $value"}
                deferred2.onAwait{"Result $it"}
                deferred3.onAwait{"Result $it"}
            }
            println("Coroutine paling cepat : $win")
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testSelectChannel(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val receiveChannel1:ReceiveChannel<Int> = scope.produce {
            delay(1_000)
            send(1_000)
        }

        val receiveChannel2:ReceiveChannel<Int> = scope.produce {
            delay(2_000)
            send(2_000)
        }

        val receiveChannel3:ReceiveChannel<Int> = scope.produce {
            delay(3_000)
            send(3_000)
        }

        val job = scope.launch {
            val win: String = select<String>{
                // mencari coroutine mana yang paling cepat selesai.
                receiveChannel1.onReceive{value -> "Result $value"}
                receiveChannel2.onReceiveCatching{"Result $it"}
                receiveChannel3.onReceive{"Result $it"}
            }
            println("Coroutine paling cepat : $win")
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testSelectChannelAndDeferred(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val receiveChannel1:ReceiveChannel<Int> = scope.produce {
            delay(1_000)
            send(1_000)
        }

        val deferred2:Deferred<Int> = scope.async {
            delay(2_000)
            2_000
        }

        val defereed3:Deferred<Int> = scope.async {
            delay(3_000)
            3_000
        }

        val job = scope.launch {
            val win: String = select<String>{
                // mencari coroutine mana yang paling cepat selesai.
                receiveChannel1.onReceive{value -> "Result $value"}
                deferred2.onAwait{"Result $it"}
                defereed3.onAwait{"Result $it"}
            }
            println("Coroutine paling cepat : $win")
        }

        runBlocking {
            job.join()
        }
    }
}