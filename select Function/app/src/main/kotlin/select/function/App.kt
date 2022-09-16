/**
    Select Function
    - select function memungkinkan kita untuk menunggu beberapa suspending function dan memilih yang pertama datanya
      tersedia.
    - select Function dapat digunakan di Deferred dan juga Channel.
    - jadi select function dapat digunakan pada coroutine yang mengembalikan value.
    - Untuk Deferred, kita dapat menggunakan onAwait.
    - dan untuk ReceiveChannel, kita dapat menggunakan onReceive.
 */
package select.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
