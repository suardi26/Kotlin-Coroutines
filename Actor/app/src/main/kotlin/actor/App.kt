/**
     Actor
     - Pada saat kita menggunakan produce() function, kita membuat  coroutine sekaligus sebagai channel sender-nya.
     - Untuk membuat coroutine sekaligus channel receiver, kita bisa menggunakan actor() function.
     - Konsep seperti dikenal dengan konsep Actor Model.
     - Jadi kalau Produce itu return value-nya receive channel digunakan untuk menerima data, maka actor return
       valuenya yaitu send Channel digunakan untuk mengirim data ke channel yang ada di actor ini.
 */
package actor

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
