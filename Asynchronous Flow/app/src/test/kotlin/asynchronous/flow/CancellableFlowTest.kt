package asynchronous.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Test

class CancellableFlowTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100){
            emit(it)
        }
    }

    @Test
    fun testCancellableFlow(){
        val scope = CoroutineScope(Dispatchers.IO)
        runBlocking {
            val job: Job = scope.launch {
                numberFlow()
                    .onEach {
                       if ( it > 10) cancel() // melakukan cancel coroutine scope.
                       else println(it)
                    }
                    .collect()
            }

            job.join()
        }
    }
}