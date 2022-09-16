/**

    Callable
    - Sebelumnya kita sudah tau, bahwa Thread akan mengeksekusi isi method run yang ada di interface Runnable, hanya
      saja masalahnya, return value dari Runnable adalah void (Unit), artinya tidak mengembalikan data.
    - Jika kita ingin mengeksekusi sebuah kode yang mengembalikan data, kita dapat menggunakan interface Callable, dimana
      terdapat method call dan return value-nya adalah generic.
    - Kita dapat menggunakan ExecutorService.submit(callable) untuk mengeksekusi Callable, dan hasilnya adalah
      object yang namanya Future<T>, dan generic Type nya sesuai dengan Callable-nya ketika String maka generic type pada
      Future<String>.
    - Untuk memasukan Runnable pada antrian ExecutorService maka kita dapat menggunakan ExecutorService.execute(runnable),
      namun pada Callable kita dapat menggunakan ExecutorService.submit(callable).

    Future
    - Future merupakan return value untuk mengeksekusi Callable.
    - Dengan Future, kita dapat mengecek status apakah telah selesai, atau bisa mendapatkan data hasil return callable,
      atau bahkan membatalkan proses callable yang sedang berjalan.
 */
package future

class App {
    // Contohnya pada bagian Test.
}

