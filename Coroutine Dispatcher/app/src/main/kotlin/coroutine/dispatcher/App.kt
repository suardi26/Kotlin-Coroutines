/**
    Coroutine Dispatcher
    - Selain ada Job di dalam CoroutineContext, ada juga object CoroutineDispatcher.
    - CoroutineDispatcher digunakan untuk menentukan thread mana yang bertanggung jawab untuk mengeksekusi coroutine.
    - Secara default sudah ada setting default dispatcher, namun kita bisa menggantinya jika kita mau.

    Dispatchers
    - Ada object Dispatchers yang dapat kita gunakan untuk mengganti CoroutineDispatcher
        - Dispatchers.Default, ini adalah default dispatcher, isinya minimal 2 thread, atau sebanyak jumlah cpu
          (mana yang lebih banyak). Dispatcher ini cocok untuk proses coroutine yang cpu-bound.
        - Dispatcher.IO, ini adalah dispatcher yang berisikan thread sesuai dengan kebutuhan, ketika butuh akan dibuat,
          ketika sudah tidak dibutuhkan, akan dihapus, mirip cache thread pool diexecutor service. Dispatcher ini akan
          sharing thread dengan Default dispatcher, maksudnya thread-nya akan disharing dari Dispatchers.Default, kalau
          sudah berkurang thread-nya baru dia akan bikin sendiri si Dispatcher.IO, jadi misal ketika diprint
          currentThread.name bisa saja akan sama dengan Dispatchers.Default karena secara default dia akan sharing
          Dispatchers.Default terlebih dahulu ketika sudah penuh maka akan dibuat Dispatcher.IO.
        - Dispatchers.Main, ini adalah dispatchers yang berisikan main thread UI, cocok ketika kita butuh running
          pada thread main seperti di Java Swing, JavaFX atau Android. Untuk menggunakan ini, kita harus menambah library
          UI tambahan.

    Unconfined vs Confined
    - Selain Default, IO dan Main, ada juga beberapa dispatchers yang lain
        - Dispatchers.Unconfined, ini adalah dispatcher yang tidak menunjuk thread apapun, biasanya akan melanjutkan
          thread di coroutine sebelumnya.
        - Confined (tanpa parameter), ini adalah dispatcher yang akan melanjutkan thread dari coroutine sebelumnya.
    - Apa bedanya Unconfined dan Confined, pada Unconfined, thread bisa berubah di tengah jalan jika memang terdapat
      code yang melakukan perubahan thread, sedangkan pada Confined tidak berubah ketika sudah ditentukan thread
      sebelumnya adalah A maka dia akan selamanya pake thread A terus.
 */
package coroutine.dispatcher

class App {
    // Contohnya ada di bagian Test.
}
