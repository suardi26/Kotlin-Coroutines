/**
    awaitAll Function
    - Pada job, tersedia joinAll untuk menunggu semua launch coroutine selesai.
    - Kotlin juga menyediakan awaitAll untuk menunggu semua Deferred selesai mengembalikan value.
    - awaitAll merupakan generic function, dan mengembalikan List<T> data hasil dari semua Deferred-nya.
    - Pastikan value yang dikembalikan semua Deferred sama  sehingga menghasilkan List<T> yang sama
      misal : List<Int>, List<String>, dll. Namun ketika tidak sama maka function awaitAll akan mengembalikan List<Any>.
 */
package awaitall.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}


