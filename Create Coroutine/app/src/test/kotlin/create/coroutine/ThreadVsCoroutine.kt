package create.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class ThreadVsCoroutine {

    // Melakukan Perbandingan Thread dan Coroutine.
        @Test
        fun testThread(){
            repeat(100_000){
                thread {
                    Thread.sleep(1_000)
                    println("Done $it : ${Date()} : ${Thread.currentThread().name}")

                }
            }
            println("Waiting")
            Thread.sleep(3_000)
            println("Finish")
        }

        @Test
        fun testCoroutine(){
            repeat(100_000){
                GlobalScope.launch {
                    delay(1_000)
                    println("Done $it : ${Date()} : ${Thread.currentThread().name}")

                }
            }
            println("Waiting")
            runBlocking {
                delay(3_000)
            }
            println("Finish")
        }


}

/**
    Kesimpulannya :
        - Pada Thread terdapat banyak sekali Thread Untuk mengeksekusi process. Sedangkan pada coroutine terdapat
          12 Thread.
        - Sehingga Thread lebih hemat, dikarenakan pada saat delay 1 detik maka Thread-nya akan berganti ke coroutine
          yang lain.
        - Jadi menggunakan coroutine, sebernarnya adalah gabungan antara Concurrency Programming karena Process-nya di
          eksekusi secara bergantian, dan juga Parallel Programming karena memiliki Beberapa Thread yang jalan bersamaan
          tapi hanya sedikit Thread yang digunakan.
 */
