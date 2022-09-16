package shared.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.jupiter.api.Test
import java.util.*

class SharedFlowTest {

    @Test
    fun testSharedFlow(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        // Membuat object MutableSharedFlow<Int>
        val sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow<Int>()

        scope.launch {
            repeat(10){

                println("   Send     1 : $it : ${Date()}")
                // mengirim data dengan function emit, setiap 1 detik.
                sharedFlow.emit(it)
                delay(1_000)
            }
        }

        scope.launch {
            // Untuk membuat receiver dari Shared Flow, kita dapat menggunakan function asSharedFlow()
            sharedFlow.asSharedFlow()
                 // menambahkan buffer dimana coroutine yang mengirim tidak menunggu semua coroutine selesai menerima data
                 // baru mengirim lagi. Sehingga data pada Job 1 diterima setiap 1 detik.
                .buffer(10)
                .map {"Receive Job 1 : $it : ${Date()}"}
                .collect(){
                    delay(1_000)
                    println(it)
                }
        }

        scope.launch {
            // Untuk membuat receiver dari Shared Flow, kita dapat menggunakan function asSharedFlow()
            sharedFlow.asSharedFlow()
                .buffer(10)
                 // Meskipun menggunakan buffer pada Job 2 akan tetapi, data yang diterima tetap setiap 2 detik karena
                 // delay-nya memang 2 detik.
                .map { "Receive Job 2 : $it : ${Date()}"}
                .collect(){
                    delay(2_000)
                    println(it)
                }
        }
        runBlocking {
            delay(22_000)
            scope.cancel()
        }
    }
}