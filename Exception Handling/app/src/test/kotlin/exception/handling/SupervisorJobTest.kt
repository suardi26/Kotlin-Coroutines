package exception.handling

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class SupervisorJobTest {
    @Test
    fun testJobExceptionHandlerWrong(){
        val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler(){ context, throwable ->
            println("Error : ${throwable.message}")
        }

        // Membuat Dispatcher
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Scope
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        runBlocking {
            val job: Job = scope.launch {

                // Membuat child Coroutine
                // Dan CoroutineExceptionHandler tidak dipanggil karena jika throw Exception pada coroutine ini,
                // sebenarnya yang boleh melakukan exception handling bukan di child coroutine namun akan di dieskalasi
                // pada parent coroutine.
                launch(exceptionHandler) {
                    println("Job Child")
                    throw IllegalArgumentException("Child Error")
                }
            }
            job.join()
        }
    }

    @Test
    fun testSupervisorJobExceptionHandler(){
        val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler(){ context, throwable ->
            println("Error : ${throwable.message}")
        }

        // Membuat Dispatcher
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Scope
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        runBlocking {
            val job: Job = scope.launch {

                supervisorScope {

                    // Membuat child Coroutine di dalam supervisorScope sehingga dapat melakukan ExceptionHandler
                    launch(exceptionHandler) {

                        // memasukan CoroutineExceptionHandler harus pada coroutine yang paling atas sesudah
                        // function supervisorScope.
                        launch {
                            println("Job Child")
                            throw IllegalArgumentException("Child Error")
                        }
                    }
                }
            }
            job.join()
        }
    }
}