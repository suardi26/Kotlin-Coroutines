/**
    Semaphore
    - Sama seperti Mutex, Semaphore juga digunakan sebagai object untuk locking
    - Namun yang membedakan, pada Mutex, kita hanya memperbolehkan 1 coroutine yang dapat mengaksesnya pada satu waktu.
    - Namun pada Semaphore, kita dapat menentukan berapa jumlah coroutine yang boleh mengakses-nya pada satu waktu.
 */
package semaphore

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
