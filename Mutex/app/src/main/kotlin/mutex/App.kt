/**
    Shared Mutable State
    - Saat kita belajar Kotlin Collection, kita sudah tau tentang Immutable dan Mutable.
    - Saat menggunakan coroutine, sangat disarankan untuk menggunakan data Immutable, apalagi jika data tersebut
      disharing ke beberapa coroutine.
    - Hal ini agar datanya aman, karena tidak bisa diubah oleh coroutine lain, jadi tidak akan terjadi problem race
      condition.
    - Namun, bagaimana jika ternyata kita memang butuh sharing mutable data beberapa coroutine secara sekaligus ?.

    Mutex
    - Mutex (Mutual exclusion) adalah salah satu fitur di Kotlin Coroutine untuk melakukan proses locking.
    - Dengan menggunakan mutex, kita bisa pastikan bahwa hanya ada 1 coroutine yang dapat mengakses kode tersebut,
      code coroutine yang lain akan menunggu sampai coroutine pertama selesai.

    - Kode dalam function withLock() hanya boleh 1 coroutine yang dapat mengaksesnya, meskipun coroutine berjalan
      secara bersamaan dan jika ada beberapa coroutine maka akan diakses secara bergiliran satu per satu.
 */
package mutex

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
