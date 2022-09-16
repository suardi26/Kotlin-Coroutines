package state.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.jupiter.api.Test
import java.util.*

class StateFlowTest {

    @Test
    fun testSharedFlow(){
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        // Membuat object MutableStateFlow<Int>
        val stateFlow: MutableStateFlow<Int> = MutableStateFlow<Int>(0) // parameter value awal = 0.

        scope.launch {
            repeat(10){

                println("   Send     1 : $it : ${Date()}")
                // mengirim data dengan function emit, setiap 1 detik.
                stateFlow.emit(it)
                delay(1_000)
            }
        }

        scope.launch {
            // Untuk membuat receiver dari State Flow, kita dapat menggunakan function asStateFlow()
            stateFlow.asStateFlow()
                .map {"Receive Job 1 : $it : ${Date()}"}
                .collect(){
                    // data yang diterima tidak semuanya. karena menggunakan StateFlow dan delay-nya/process menerima data
                    // lebih lambat dari pada pengiriman data, sehingga data yang diambil adalah data yang paling
                    // baru.
                    println(it)
                    delay(2_000)
                }
        }

        runBlocking {
            delay(22_000)
            scope.cancel()
        }
    }
}