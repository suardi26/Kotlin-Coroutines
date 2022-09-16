/**
    Coroutine Scope
    - salah satu cara untuk membuat coroutine adalah Global Scope.
    - Global Scope sebenarnya adalah salah satu implementasi Coroutine Scope.
    - Semua Coroutine itu sebenarnya dijalankan dari sebuah coroutine scope.
    - Function launch dan async yang dapat digunakan untuk membuat/menjalankan coroutine sebenarnya adalah extension
      function dari coroutine scope.
    - Secara sederhana, coroutine scope adalah object life cycle-nya coroutine.

    Penggunaan Coroutine Scope
    - CoroutineScope biasanya digunakan dalam sebuah flow yang saling berhubungan.
    - Contohnya, Misal saat kita membuka sebuah halaman di mobile, maka kita akan membuat screen, lalu mengambil data
      ke server, lalu setelah mendapatkannya kita akan menampilkan data tersebut di screen.
    - Flow tersebut harus saling terintegrasi, jika misal flow tersesbut sukses maka harus sukses semua, jika dibatalkan,
      maka harus dibatalkan proses selanjutnya.
    - Hal tersebut jika diibaratkan tiap aktivitas adalah coroutine, maka flow dari awal sampai akhir tersebut di simpan
      dalam sebuah coroutine scope.

    GlobalScope
    - Sebenarnya penggunaan GlobalScope tidak dianjurkan dalam pembuatan aplikasi.
    - Hal ini dikarenakan, jika semua coroutine menggunakan GlobalScope, maka secara otomatis akan sharing
      coroutine scope, hal ini agak menyulitkan saat kita misal ingin membatalkan sebuah flow, karena saat sebuah coroutine
      scope dibatalkan, maka semua coroutine yang terdapat di scope tersebut akan dibatalkan.
    - Jadi GlobalScope cuma untuk sample atau digunakan untuk belajar, dan kenyataannya nanti kita akan membuat
      coroutine scope sendiri.
 */
package coroutine.scope

class App {
// Contohnya ada di bagian Test.
}

