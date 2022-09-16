package executor.service

import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThreadTest {

    // Contoh Membuat satu Thread Menggunakan ExecutorService
    @Test
    fun testSingleThreadPool() {

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()
        repeat(10){

            val runnable: Runnable = Runnable{
                Thread.sleep(1_000) // 1 detik
                println("Done $it in ${Thread.currentThread().name} ${Date()}")
            }
            // Memasukan Proses/Runnable pada ExecutorService dalam bentuk antrian, dan akan di eksekusi nantinya oleh Thread.
            executorService.execute(runnable)
            println("Selesai Memasukan Runnable/Proses $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("DONE PROGRAM ${Date()}")
    }

    // Contoh Membuat beberapa Thread tergantung parameter yang dimasukan Menggunakan ExecutorService
    @Test
    fun testFixThreadPool() {

        val executorService: ExecutorService = Executors.newFixedThreadPool(3)
        repeat(10){

            val runnable: Runnable = Runnable{
                Thread.sleep(1_000) // 1 detik
                println("Done $it in ${Thread.currentThread().name} ${Date()}")
            }
            // Memasukan Proses/Runnable pada ExecutorService dalam bentuk antrian, dan akan di eksekusi nantinya oleh Thread.
            executorService.execute(runnable)
            println("Selesai Memasukan Runnable/Proses $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("DONE PROGRAM ${Date()}")
    }

    // Contoh Membuat Thread yang akan meningkat sesuai kebutuhan dan juga tanpa batasan, dengan Menggunakan ExecutorService.
    @Test
    fun testCacheThreadPool() {

        val executorService: ExecutorService = Executors.newCachedThreadPool()
        repeat(10){

            val runnable: Runnable = Runnable{
                Thread.sleep(1_000) // 1 detik
                println("Done $it in ${Thread.currentThread().name} ${Date()}")
            }
            // Memasukan Proses/Runnable pada ExecutorService dalam bentuk antrian, dan akan di eksekusi nantinya oleh Thread.
            executorService.execute(runnable)
            println("Selesai Memasukan Runnable/Proses $it")
        }
        println("Menunggu")
        Thread.sleep(11_000)
        println("DONE PROGRAM ${Date()}")
    }
}