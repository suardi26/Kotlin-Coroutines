package asynchronous.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowExceptionTest {

    suspend fun numberFlow(): Flow<Int> = flow {
        repeat(100){
            emit(it)
        }
    }

    suspend fun changeToString(number: Int): String {
        delay(100)
        return "Number : $number"
    }

    @Test
    fun testFlowException(){
        runBlocking {
            numberFlow()
                // Melakukan pengecekan number, dimana number harus dibawah 10, ketika false maka akan throw
                // IllegalStateException exception.
                .map { number -> check(number < 10); number }
                .onEach { number -> println(number) }
                .catch { throwable -> println("Error ${throwable.message}") } // mirip seperti catch.
                .onCompletion { println("Done") } // mirip seperti finally.
                // menggunakan collect() tanpa lambda, dikarenakan number-nya sudah di print menggunakan function onEach()
                .collect()
        }
    }
}