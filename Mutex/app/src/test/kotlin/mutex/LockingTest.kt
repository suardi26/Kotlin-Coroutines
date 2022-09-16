package mutex

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class LockingTest {

    // Contoh Problem Race Condition.
    @Test
    fun testRestCondition(){
        var counter: Int = 0

        // Membuat dispatcher
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope menggunakan dispatcher yang telah dibuat.
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        // melakukan launch coroutine sebanyak 100 kali.
        repeat(100){
            scope.launch {
                // dan coroutine-nya melakukan 1000 kali counter (increment)
                repeat(1_000){
                    counter++
                }
            }
        }

        runBlocking {
            delay(5_000)

            // Seharusnya Counter-nya bernilai 100_000 tapi nilainya tidak sampai karena, coroutine berjalan bersama
            // dan beberapa coroutine dapat melakukan increment bersamaan sehingga dihitung 1 kalin proses increment
            // variable counter, hal ini biasa disebut Problem Race Condition.
            println("Total Counter : $counter")
        }

    }

    @Test
    fun testMutex(){
        var counter: Int = 0

        // Membuat dispatcher
        val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        // Membuat Coroutine Scope menggunakan dispatcher yang telah dibuat.
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        // Membuat Object Mutex
        val mutex:Mutex = Mutex()

        // melakukan launch coroutine sebanyak 100 kali.
        repeat(100){
            scope.launch {
                // dan coroutine-nya melakukan 1000 kali counter (increment)
                repeat(1_000){

                    // Kode dalam function withLock() hanya boleh 1 coroutine yang dapat mengaksesnya, meskipun coroutine
                    // berjalan secara bersamaan dan jika ada beberapa coroutine maka akan diakses secara bergiliran satu per satu.
                    mutex.withLock {
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