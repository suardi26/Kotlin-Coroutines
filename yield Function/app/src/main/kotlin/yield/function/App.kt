/**
    yield Function
    - Dikarenakan suspend function akan dijalankan secara sequential, artinya jika ada sebuah suspend function yang
      panjang dan lama, ada baiknya kita beri kesempatan ke suspend function lainnya untuk dijalankan.
    - Coroutine berjalan secara concurrent, artinya 1 dispatcher dapat digunakan untuk mengeksekusi beberapa coroutine
      secara bergantian. Saat coroutine kita berjalan, dan jika kita ingin memberi kesempatan ke coroutine yang
      lain untuk berjalan, kita dapat menggunakan yield function.
    - yield function itu dapat di cancel, artinya jika sebuah coroutine telah dibatalkan, maka secara otomatis yield
      function akan throw CancellationExeption.
 */
package yield.function

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
