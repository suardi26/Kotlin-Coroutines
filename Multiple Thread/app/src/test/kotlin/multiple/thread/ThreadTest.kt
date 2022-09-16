package multiple.thread

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

// Membuat Multiple Thread.
class ThreadTest {

    @Test
    fun testMultipleThread(){

        // Thread ke-1
        // Contoh Membuat Thread dari interface Runnable.

            val thread1: Thread = Thread(Runnable{
                println("Start Thread 1 :  ${Thread.currentThread().name} : ${Date()}")
                Thread.sleep(2_000) // 2 detik
                println("Finish Thread 1 :  ${Thread.currentThread().name} : ${Date()}")
            })
            thread1.start()

        // Thread ke-2
        // Contoh Membuat Thread dengan helper function "thread()" pada Kotlin.
            val thread2: Thread = thread(start = true) { // start = true => langsung mulai Thread-nya.
                println( println("Start Thread 2 :  ${Thread.currentThread().name} : ${Date()}"))
                Thread.sleep(2_000) // 2 detik
                println("Finish Thread 2 : ${Thread.currentThread().name} : ${Date()}")
            }

            println("Menunggu Selesai")
            // Karena Thread berjalan Pararel maka pastikan Thread yang dibuat harus selesai di jalankan sebelum main Thread
            // pada JUnit (Test worker) selesai dieksekusi, karena ketika main Thread selesai dieksekusi maka semua Thread
            // akan dimatikan artinya aplikasinya di close, jadi perlu diperhatikan bahwa sebelum aplikasi-nya selesai
            // atau main thread-nya selesai, pastikan semua thread-nya selesai terlebih dahulu.
            Thread.sleep(3_000) // 3 detik
            println("SELESAI")
    }
}