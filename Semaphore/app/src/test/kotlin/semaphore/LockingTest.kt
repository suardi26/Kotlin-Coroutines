package semaphore

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors


class LockingTest {

    @Test
    fun testSemaphore(){
        var counter: Int = 0

        // Membuat dispatcher
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope menggunakan dispatcher yang telah dibuat.
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        // Membuat Object semaphore dan arguments permits-nya 2 artinya dapat digunakan oleh 2 coroutine pada satu waktu.
        val semaphore: Semaphore = Semaphore(permits = 2)

        // melakukan launch coroutine sebanyak 100 kali.
        repeat(100){
            scope.launch {
                // dan coroutine-nya melakukan 1000 kali counter (increment)
                repeat(1_000){

                    // Kode dalam function withPermit() hanya boleh 2 coroutine yang dapat mengaksesnya.
                    // hasil nya pun tidak akurat karena tetap berjalan secara bersamaan 2 coroutine.
                    // dan ketika coroutine-nya ditambah(permits-nya) maka akurasinya akan semakin berkurang.
                    semaphore.withPermit {
                        counter++
                    }
                }
            }
        }

        runBlocking {
            delay(5_000)

            // Total Counter-nya sekitar 100_000 dikarenakan di lock menggunakan Mutex (Mutual exclusion)
            println("Total Counter : $counter")
        }

    }

}