package sequential.suspend.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class SequentialSuspendFunctionTest {

    suspend fun getFoo(): Int {
        delay(1_000)
        return 10
    }

    suspend fun getBar(): Int{
        delay(1_000)
        return 10
    }

    @Test
    fun testSequential(){
        // Memanggil beberapa suspend function dan dieksekusi secara sequential
        runBlocking {

            val time: Long = measureTimeMillis {
                getFoo()
                getBar()
            }
            println("Total Time $time") // total waktu 2 seconds
        }
    }

    @Test
    fun testSequentialCoroutine(){
        // Memanggil beberapa suspend function dan dieksekusi secara sequential
        runBlocking {

           val job: Job = GlobalScope.launch {
               val time: Long = measureTimeMillis {
                   getFoo()
                   getBar()
               }
               println("Total Time $time") // total waktu 2 seconds
           }

           job.join()
        }
    }

    @Test
    fun testConcurrent(){
       runBlocking {
           val time: Long = measureTimeMillis {
               val job1: Job = GlobalScope.launch { getFoo() }
               val job2: Job = GlobalScope.launch { getBar() }
               joinAll(job1,job2)
           }
           println("Total Time $time") // total waktu 1 seconds
       }
    }
}