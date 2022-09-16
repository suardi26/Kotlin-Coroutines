/**
    ticker Function
    - ticker adalah function yang dapat kita gunakan untuk membuat channel mirip dengan timer.
    - Dengan ticker, kita bisa menentukan sebuah pesan akan dikirim dalam waktu timer yang sudah kita tentukan.
    - ini cocok jika kita ingin membuat timer menggunakan coroutine dan channel.
    - Return value dari ticker function adalah ReceiveChannel<Unit>, dan setiap kita receive data, datanya hanya berupa
      data null.
 */
package ticker.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
