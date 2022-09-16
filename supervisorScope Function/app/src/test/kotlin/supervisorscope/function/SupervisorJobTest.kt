package supervisorscope.function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SupervisorJobTest {
    @Test
    fun testSupervisorScopeFunction(){

        val dispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope dengan Job.
        val scope: CoroutineScope = CoroutineScope(dispatcher + Job())

        runBlocking {
            scope.launch {

                // Membuat Child Coroutine Scope, dengan tipe supervisorScope
                // Sehingga Child Coroutine Scope berjalan independen, dan tidak mempengaruhi coroutine yang lain
                // ketika terjadi error pada coroutine tersebut (SupervisorJob).
                supervisorScope {
                    launch {
                        delay(2_000)
                        println("Child 1 Selesai")
                    }

                    launch {
                        delay(1_000)
                        throw IllegalArgumentException("Child 2 Error !!!")
                    }
                }
            }

            delay(3_000)
        }

    }
}