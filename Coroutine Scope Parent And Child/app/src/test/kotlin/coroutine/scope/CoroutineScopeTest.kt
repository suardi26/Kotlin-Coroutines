package coroutine.scope

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.coroutineContext

class CoroutineScopeTest {

    @Test
    fun testParentChildDispatcher(){
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope (parent Coroutine Scope)
        val scope: CoroutineScope =  CoroutineScope(dispatcher)

        val job = scope.launch {
            println("Parent Scope : ${Thread.currentThread().name}")

            // Membuat Coroutine Scope menggunakan coroutineScope function (Child Coroutine Scope)
            // dan CoroutineContext-nya akan mengikuti dengan CoroutineContext yang memanggil-nya atau parent scope-nya.
            coroutineScope{
                launch {
                    println("Child Scope : ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.join()
            // maka dapat dilihat bahwa dispatchers-nya sama, meskipun beda thread karena thread yang dibuat untuk
            // dispatcher adalah 10.
        }
    }

    @Test
    fun testParentChildCancel(){
        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope (parent Coroutine Scope)
        val scope: CoroutineScope =  CoroutineScope(dispatcher)

        val job = scope.launch {
            println("Parent Scope : ${Thread.currentThread().name}")

            // Membuat Coroutine Scope menggunakan coroutineScope function (Child Coroutine Scope)
            // dan CoroutineContext-nya akan mengikuti dengan CoroutineContext yang memanggil-nya atau parent scope-nya.
            coroutineScope{
                launch {
                    delay(2_000)
                    println("Child Scope : ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            // akan di cancel parent Scope-nya, dan secara otomatis parent dan juga child coroutine scope-nya
            // akan dibatalkan.
            job.cancelAndJoin()
        }
    }
}