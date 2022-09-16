package channel

import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ChannelTest {

    @Test
    fun testChannel(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>()

            val job1: Job = launch {
                println("Send Data 1 to Channel")
                channel.send(1)

                println("Send Data 2 to Channel")
                channel.send(2)
            }

            val job2: Job = launch {
                println("Receive data ${channel.receive()}")
                println("Receive data ${channel.receive()}")
            }

            joinAll(job1, job2)
            channel.close()

        }
    }

    @Test
    fun testChannelUnlimited(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>(capacity = Channel.UNLIMITED)

            val job1: Job = launch {
                println("Send Data 1 to Channel")
                channel.send(1)

                println("Send Data 2 to Channel")
                channel.send(2)

            }

            val job2: Job = launch {
                println("Receive data ${channel.receive()}")
                println("Receive data ${channel.receive()}")
            }

            joinAll(job1, job2)
            channel.close()

        }
    }

    @Test
    fun testChannelConflated(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>(capacity = Channel.CONFLATED)

            val job1: Job = launch {
                println("Send Data 1 to Channel")
                channel.send(1)

                println("Send Data 2 to Channel")
                channel.send(2)

            }
            job1.join()

            val job2: Job = launch {
                // data 1 diterima tapi akan dihapus dan digantikan oleh data 2. karena menggunakan Channel.CONFLATED.
                println("Receive data ${channel.receive()}")
            }

            job2.join()
            channel.close()

        }
    }

    @Test
    fun testChannelBufferSuspend(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.SUSPEND)

            val job1: Job = launch {
                repeat(100){
                    println("Send data $it to Channel")
                    channel.send(it)
                }

            }
            job1.join()

            val job2: Job = launch {
                repeat(10){
                    // Ketika datanya yang dikirim melebihi kapasitas buffer, pada contoh diatas 0-9 maka data ke-11
                    // yaitu 10 akan terjadi suspend alias menunggu data yang dikirim harus diterima terlebih dahulu,
                    // baru melanjutkan ke data selanjutnya, dikarenakan buffer-nya cuma 10.
                    println("Receive data ${channel.receive()}")
                }
            }

            job2.join()
            channel.close()

        }
    }
    @Test
    fun testChannelBufferOverflowDropOldest(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.DROP_OLDEST)

            val job1: Job = launch {
                repeat(100){
                    println("Send data $it to Channel")
                    channel.send(it)
                }

            }
            job1.join()

            val job2: Job = launch {
                repeat(10){
                    // Karena menggunakan BufferOverflow.DROP_OLDEST, maka data yang paling depan dibuang dan 10 data
                    // terakhir yang dimasukan, itu yang diterima.
                    println("Receive data ${channel.receive()}")
                }
            }

            job2.join()
            channel.close()

        }
    }

    @Test
    fun testChannelBufferOverflowDropLatest(){
        runBlocking {
            // Membuat object Channel
            val channel: Channel<Int> = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.DROP_LATEST)

            val job1: Job = launch {
                repeat(100){
                    println("Send data $it to Channel")
                    channel.send(it)
                }

            }
            job1.join()

            val job2: Job = launch {
                repeat(10){
                    // Karena menggunakan BufferOverflow.DROP_LATEST, maka data yang paling belakang dibuang dan 10 data
                    // pertama yang dimasukan, itu yang diterima.
                    println("Receive data ${channel.receive()}")
                }
            }

            job2.join()
            channel.close()

        }
    }

     @Test
     fun testChannelUndeliveredElement(){
         runBlocking {
             // Membuat Object Channel namun dilengkapi dengan parameter lambda digunakan untuk onUndeliveredElement,
             // ketika mencoba mengirim data ke channel yang sudah close, maka lambda ini akan dipanggil dan dieksekusi.
             val channel: Channel<Int> = Channel<Int>(capacity = 10){ element ->
                 println("Undelivered Element $element")
             }
             channel.close()

             val job: Job = launch{
                 channel.send(10)
                 channel.send(20)
             }
             job.join()
         }

     }
}