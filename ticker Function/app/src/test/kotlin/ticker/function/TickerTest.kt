package ticker.function

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*

class TickerTest {

    @Test
    fun testTimerManual(){

        // Menggunakn function ticker()
        val receiveChannel: ReceiveChannel<String?> = GlobalScope.produce<String?> {
            while (true){
                delay(1_000)
                send(null)
            }
        }


        runBlocking {
            val job = launch {
                repeat(10){
                    receiveChannel.receive()
                    println(Date())
                }
            }
            job.join()
        }
    }

    @Test
    fun testTicker(){

        // Menggunakn function ticker()
        val receiveChannel: ReceiveChannel<Unit> = ticker(delayMillis = 1_000)


        runBlocking {
            val job = launch {
                repeat(10){
                    receiveChannel.receive()
                    println(Date())
                }
            }
            job.join()
        }
    }
}