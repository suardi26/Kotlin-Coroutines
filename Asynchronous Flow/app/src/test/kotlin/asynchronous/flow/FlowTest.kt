package asynchronous.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowTest {

    @Test
    fun testFlow(){
        // Membuat Coroutines dengan menggunakan function flow()
        val flow1: Flow<Int> = flow(){
            println("Start Flow")
            repeat(100){
                println("Emit $it")
                // Mengirimkan data menggunakan function emit()
                emit(it)
            }
        }

        // mengakses data yang ada di flow menggunakan function collect()
        // dikarenakan function collect itu suspend function maka kita harus mengambil datanya dalam sebuah coroutine
        // contohnya menggunakan runBlocking(){...}
        runBlocking {
            // Ketika belum memanggil function collect() maka flow tidak akan dieksekusi misal pada code yang
            // ada di dalam flow() diatas = println("Start Flow") tidak akan dieksekusi.
            flow1.collect(){ it -> println("Receive $it") }
        }
    }
}