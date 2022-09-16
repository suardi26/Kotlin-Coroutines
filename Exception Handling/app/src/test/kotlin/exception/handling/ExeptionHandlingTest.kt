package exception.handling

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import javax.print.attribute.standard.Finishings

class ExeptionHandlingTest {

    @Test
    fun testExceptionLaunch(){
        runBlocking {
            val job = GlobalScope.launch {
                println("Start Coroutine")
                throw IllegalArgumentException()
            }
            // Pada saat memanggil function join() dari Object Job, tidak mengetahui bahwa object Job ada terjadi
            // Error/Exception, dimana hal ini terjadi karena default behavior pada saat menggunakan function launch().


            // jika ada throw exception di dalam function launch() maka pada saat pemanggilan
            // object Job maka Erorrnya diabaikan dan melanjutkan baris code selanjutnya
            job.join()
            println("Finish")
        }
    }

    @Test
    fun testExceptionAsync1(){
        runBlocking {
            val deferred: Deferred<Nothing> = GlobalScope.async {
                println("Start coroutine")
                throw IllegalArgumentException()
            }
            // Bedanya dari function launch, jika ada error di function launch() maka pada saat pemanggilan
            // object Job maka Erorrnya diabaikan dan melanjutkan baris code selanjutnya, namun pada function async()
            // ketika throw exception di dalam function tersebut, dan pada saat pemanggilan function await()
            // menggunakan object Deferred<T> maka akan terjadi Error karena tidak di Handling dan code selanjutnya pun
            // tidak dieksekusi.
            deferred.await()
            println("Finish")
        }
    }

    @Test
    fun testExceptionAsync2(){
        runBlocking {
            val deferred: Deferred<Nothing> = GlobalScope.async {
                println("Start coroutine")
                throw IllegalArgumentException()
            }
            // Menangkap Exception dari function async()
            try {
                deferred.await()
            }catch (erorr: IllegalArgumentException){
                println("Errornya : $erorr")
            }finally{
                println("Finish")
            }

        }
    }

    @Test
    fun testExceptionHandler(){

        // Membuat CoroutineExceptionHandler.
        val exceptionHandling: CoroutineExceptionHandler = CoroutineExceptionHandler() { context, throwable ->
            println("Error Exception Handler !!!")
            println("Throwable : ${throwable.message}")
        }

        // dikarenakan CoroutineExceptionHandler adalah coroutine context maka kita juga dapat memasukannya ke
        // dalam sebuah CoroutineScope.
        val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO + exceptionHandling)

        runBlocking {

            // Memasukan CoroutineExceptionHandler pada parameter launch, dikarenakan CoroutineExceptionHandler adalah
            // turunan dari CoroutineContext.Element, sehingga kita dapat menambahkannya kedalam coroutine context.
            val job = GlobalScope.launch(exceptionHandling) {
                println("Start Coroutine")
                throw IllegalArgumentException("Message Error")
            }


            // jika ada throw exception di dalam function launch() maka pada saat pemanggilan
            // object Job maka Erorrnya akan ditangani oleh CoroutineExceptionHandler yang dimasukan ke dalam
            // coroutine context lewat parameter function launch(exceptionHandling)
            job.join()
            println("Finish")

            // Menggunakan scope yang sudah ditambahkan CoroutineExceptionHandler.
            val job2 = coroutineScope.launch(exceptionHandling) {
                println("Start Coroutine")
                throw IllegalArgumentException("Message Error")
            }

            job2.join()
            println("Finish Job2")
        }
    }
}