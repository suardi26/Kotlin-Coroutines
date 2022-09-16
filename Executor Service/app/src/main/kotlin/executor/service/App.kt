/**
    Executor Service
    - Thread adalah object yang lumayan berat, sekitar 512kb - 1MB tergantung jumlah bit OS (32/64), sehingga jika
      terlalu banyak membuat Thread, penggunaan memory pada aplikasi kita akan membengkak.
    - Sehingga penggunaan Thread secara manual sangat tidak disarankan.
    - Thread sendiri sebenarnya dapat digunakan ulang jika proses sudah selesai dilakukan (reuse).
    - Executor Service adalah fitur pada JVM yang dapat digunakan untuk manajemen Thread.
    - Penggunaan ExecutorService lebih direkomendasikan dibandingkan menggunakan Thread secara manual.
    - ExecutorService adalah sebuah interface, untuk membuat objectnya, kita dapat menggunakan class "Executors",
      terdapat banyak helper method/function pada class "Executors".

    Executors Method
        Method                      Keterangan
        - newSingleThreadExecutor   => Membuat ExecutorService dengan 1 thread.
        - newFixedThreadPool(int)   => Membuat ExecutorService dengan n thread.
        - newCachedThreadPool()     => Membuat ExecutorService dengan thread akan meningkat sesuai kebutuhan.
        - dll.

    Threadpool
    - Implementasi ExecutorService yang terdapat pada class Executors adalah class ThreadPoolExecutor.
    - Di dalam ThreadPool, terdapat data queue (antrian) tempat menyimpan semua proses sebelum dieksekusi oleh Thread
      yang tersedia di ThreadPool.
    - Hal ini jadi kita dapat mengeksekusi sebanyak-banyaknya Runnable walaupun Thread tidak cukup untuk mengeksekusi
      semua Runnable.
    - Runnable yang tidak dieksekusi akan menunggu di queue sampai Thread sudah selesai mengeksekusi Runnable yang lain.
    - Misal terdapat 100 object Runnable, kemudian terdapat 10 Thread, itu tidak masalah karena yang 100 object Runnable
      akan masuk terlebih dahulu di ExecutorService(ThreadPool) kemudian Thread yang 10 akan mengambil proses dan
      dieksekusi secara bersamaan dan setelah selesai maka akan mengambil proses lagi sebanyak 10, begitu seterusnya
      sampai semua proses yang terdapat di dalam queue (antrian) habis.

 */
package executor.service

class App {

    // Contohnya pada bagian Test.

}


