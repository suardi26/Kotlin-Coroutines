/**
    Non Cancellable Context
    - Setelah coroutine di cancel, dan jika kita ingin melakukan sesuatu,
      kita dapat menggunakan block try-finally.
    - Namun dalam block finally, kita tidak dapat menggunakan suspend function yang mengecek isActive, karena otomatis
      akan bernilai false, dan otomatis batal, jadi perlu diperhatikan.

    - Jika kita butuh memanggil suspend function yang mengecek is Active di block finally, dan berharap tidak dibatalkan
      eksekusinya, maka kita dapat menggunakan NonCancellable.
    - NonCancelable adalah coroutine context yang meng-override nilai-nilai cancellable sehingga seakan-akan coroutine
      tersebut tidak dibatalkan.
    - Ketika kita ingin membuat code program di dalam coroutine dan tidak dapat dibatalkan maka dapat menggunakan Coroutine
      Context yang namanya NonCancellable.
 */
package non.cancellable.context

class App {
   // contohnya di bagian Test.
}
