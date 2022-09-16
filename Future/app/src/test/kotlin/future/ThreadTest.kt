package future

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.system.measureTimeMillis


class ThreadTest {

    // Contoh membuat Thread yang mengembalikan data dengan Callable, dimana return value-nya berupa Future<T>.
    val executorService = Executors.newFixedThreadPool(10)
    fun getFoo(): Int {
        Thread.sleep(1_000)
        return 10
    }

    fun getBar(): Int {
        Thread.sleep(1_000)
        return 10
    }

    // membuat function secara parallel dengan Callback.
    @Test
    fun testFutureGet(){
        val time = measureTimeMillis {
            val foo: Future<Int> = executorService.submit(Callable { getFoo() })
            val bar: Future<Int> = executorService.submit(Callable { getFoo() })

            val total = foo.get() + bar.get()
            println("Total is $total")
        }
        println("Time : $time")
    }

    // membuat function tanpa parallel.
    @Test
    fun testNonParallel(){
        val time: Long = measureTimeMillis {
            val foo = getFoo()
            val bar = getBar()
            val result = foo + bar
            println(result)
        }
        println("Total Time : $time Millliseconds")
    }
}