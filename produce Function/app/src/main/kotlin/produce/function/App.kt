/**
    produce function
    - Coroutine scope memiliki sebuah function bernama produce, yang digunakan untuk membuat sebuah coroutine yang
      digunakan untuk mengirim data ke channel, sederhananya kita dapat membuat channel secara mudah dengan menggunakan
      function produce ini.
    - Hasil return dari function produce adalah ReceiveChannel (parent interface dari Channel), yang hanya dapat
      digunakan untuk mengambil data.
 */
package produce.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
