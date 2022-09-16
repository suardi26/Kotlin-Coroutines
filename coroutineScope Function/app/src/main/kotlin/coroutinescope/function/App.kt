/**
    coroutineScope Function
    - Kadang pembuatan coroutine scope itu terlalu kompleks jika hanya untuk kasus-kasus yang sederhana, misal saja
      kita hanya ingin menggabungkan beberapa suspend function dalam coroutine, lalu mengembalikan nilai tersebut.
    - Pada kasus yang sederhana, kita dapat menggunakan coroutineScope function untuk menggabungkan beberapa suspend
      function.
    - Saat ada error di coroutine yang terdapat di dalam coroutine scope function tersebut akan throw
      CancellationException, maka function coroutineScope pun akan dibatalkan, maka semua coroutine yang ada didalam
      coroutineScope tersebut akan dibatalkan juga.
 */
package coroutinescope.function

class App {

}
