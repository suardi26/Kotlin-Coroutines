package create.thread

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class ThreadTest {
    @Test
    fun testThreadName1(){

        // Contoh Membuat Thread dari interface Runnable.
            val runnable: Runnable = Runnable(){
                println(Date())
                Thread.sleep(2_000) // 2 detik
                println("Finish : ${Date()}")
            }

            val thread: Thread = Thread(runnable)
            thread.start()

            println("Menunggu Selesai")
            // Karena Thread berjalan Pararel maka pastikan Thread yang dibuat harus selesai di jalankan sebelum main Thread
            // pada JUnit (Test worker) selesai dieksekusi, karena ketika main Thread selesai dieksekusi maka semua Thread
            // akan dimatikan artinya aplikasinya di close, jadi perlu diperhatikan bahwa sebelum aplikasi-nya selesai
            // atau main thread-nya selesai, pastikan semua thread-nya selesai terlebih dahulu.
            Thread.sleep(3_000) // 3 detik
            println("SELESAI")


    }

    @Test
    fun testThreadName2(){

        // Contoh Membuat Thread dengan helper function "thread()" pada Kotlin.
            thread(start = true) { // start = true => langsung mulai Thread-nya.
                println(Date())
                Thread.sleep(2_000) // 2 detik
                println("Finish : ${Date()}")
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