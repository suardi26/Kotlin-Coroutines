package coroutine.name

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineContextTest {

    @Test
    fun testCoroutineName(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + CoroutineName("parent"))

        // Boleh juga menambahkan parameter CoroutineName("Coroutine1") di function launch(){...}
        // misal : scope.launch(CoroutineName("Coroutine1")) { ... }
        val job: Job = scope.launch {
            println("Parent run in thread ${Thread.currentThread().name}")
            withContext(CoroutineName("child")){
                println("Child run in thread ${Thread.currentThread().name}")
            }
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testCoroutineNameContext(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + CoroutineName("test"))

        // Boleh juga menambahkan parameter CoroutineName("Coroutine1") di function launch(){...}
        // misal : scope.launch(CoroutineName("Coroutine1")) { ... }
        val job: Job = scope.launch {
            println("Parent run in thread ${Thread.currentThread().name}")
            withContext(Dispatchers.IO){
                println("Child run in thread ${Thread.currentThread().name}")
            }
        }

        runBlocking {
            job.join()
        }
    }
}