package asynchronous.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class OperatorFlowTest {

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
    fun testFlowOperator(){
        runBlocking {
            val flow1 = numberFlow()

            // menggunakan operator filter pada Flow, yang digunakan untuk mengambil bilangan genap.
            flow1.filter { it % 2 == 0 }
                .map { changeToString(it) }
                .collect(){println(it)}
        }
    }
}