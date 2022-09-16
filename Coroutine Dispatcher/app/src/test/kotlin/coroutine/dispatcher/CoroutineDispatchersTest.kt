package coroutine.dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineDispatchersTest {
    @Test
    fun testDispatcher(){
        runBlocking {
            println("runBlocking ${Thread.currentThread().name}")

            // menentukan thread mana yang mengeksekusi coroutine dengan CoroutineDispatcher
            val job1: Job = GlobalScope.launch(Dispatchers.Default) {
                println("Job 1 ${Thread.currentThread().name}")
            }

            val job2: Job = GlobalScope.launch (Dispatchers.IO) {
                println("Job 2 ${Thread.currentThread().name}")
            }

            joinAll(job1, job2)
        }
    }

    @Test
    fun testUnconfined(){

        // menggunkan CoroutineDispatcher (Dispatchers.Unconfined)
        runBlocking {
            println("runBlocking ${Thread.currentThread().name}")

            GlobalScope.launch(Dispatchers.Unconfined) {

                println("Unconfined (Proses 1) : ${Thread.currentThread().name}")
                delay(1_000) // dengan harapan berpindah Thread.
                println("Unconfined (Proses 2) : ${Thread.currentThread().name}")
                delay(1_000) // dengan harapan berpindah Thread.
                println("Unconfined (Proses 3) : ${Thread.currentThread().name}")
            }


        // menggunkan CoroutineDispatcher (Dispatchers.Confined), secara default tidak perlu di tambahkan.
            GlobalScope.launch{

                println("Confined (Proses 1) : ${Thread.currentThread().name}")
                delay(1_000) // dengan harapan berpindah Thread (tapi tidak akan berpindah karena Confined).
                println("Confined (Proses 2) : ${Thread.currentThread().name}")
                delay(1_000) // dengan harapan berpindah Thread (tapi tidak akan berpindah karena Confined).
                println("Confined (Proses 3) : ${Thread.currentThread().name}")
            }

            delay(3_000)
        }


    }
}