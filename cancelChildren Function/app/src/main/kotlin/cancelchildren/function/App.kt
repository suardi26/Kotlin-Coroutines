/**
    cancelChildren Function
    - Coroutine memiliki parent dan child.
    - Coroutine akan direpresentasikan sebagai Job (Deferred pun turunan dari Job), dan di Job kita bisa mendapatkan
      semua children-nya menggunakan field children. misalnya kita ingin mendapatkan semua job dari children-nya dari
      coroutine.
    - Selain itu ada sebuah function bernama cancelChildren, function ini dapat kita gunakan untuk membatalkan semua
      coroutine children.
    - Jika kita membatalkan Job parent, kita tidak perlu membatalkan children-nya secara manual, karena saat Job
      di batalkan, semua child-nya akan dibatalkan.

 */
package cancelchildren.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
