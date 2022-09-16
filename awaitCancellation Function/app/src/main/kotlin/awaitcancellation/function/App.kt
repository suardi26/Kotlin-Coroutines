/**
    awaitCancellation Function
    - Secara Default, sebuah coroutine akan berhenti ketika seluruh code selesai dijalankan
    - Jika ada kebutuhan kita tidak mau coroutine berhenti sampai di Job-nya di cancel, maka kita dapat menggunakan
      function awaitCancellation.
    - Function awaitCancellation akan throw CancellationException jika job di cancel, dan tidak akan menghentikan
      coroutine jika belum di cancel.
 */
package awaitcancellation.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
