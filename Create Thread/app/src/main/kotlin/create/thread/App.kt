/**
    Create Thread
    - Kotlin menggunakan Java Thread, sehingga pembuatan Thread di Kotlin sama seperti pembuatan Thread di Java.
    - Untuk membuat Thread, kita dapat menggunakan interface Runnable sebagai kode program yang akan dieksekusi, lalu
      menggunakan method/function Thread.start() untuk menjalankan Thread tersebut.
    - Namun perlu diingat, Thread akan berjalan secara pararel, sehingga tidak akan ditunggu oleh Thread utama (main).
    - Kotlin memiliki helper function bernama thread() jika kita ingin membuat thread lebih singkat dan mudah.
    - Karena Thread berjalan Pararel maka pastikan Thread yang dibuat harus selesai di jalankan sebelum "main" Thread
      selesai dieksekusi, karena ketika main Thread selesai dieksekusi maka semua Thread
      akan dimatikan artinya aplikasinya di close, jadi perlu diperhatikan bahwa sebelum aplikasi-nya selesai
      atau main thread-nya selesai, pastikan semua thread-nya selesai terlebih dahulu.
 */
package create.thread

import java.util.*
import kotlin.concurrent.thread

class App {
    // Contohnya pada bagian Test.
}

fun main() {

}


