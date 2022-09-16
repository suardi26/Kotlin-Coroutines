/**
    supervisorScope Function
    - Kadang ada kondisi dimana kita tidak memiliki akses untuk mengubah sebuah coroutine scope
    - Karena secara default sifatnya adalah Job, maka kita dapat menggunakan supervisorScope function untuk membuat
      coroutine yang sifatnya SupervisorJob.
 */
package supervisorscope.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

