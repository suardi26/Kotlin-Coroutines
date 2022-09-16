/**
    Problem di Java Thread
    - Java Thread tidak didesain untuk melakukan Concurrency Programming.
    - Java Thread hanya bisa melakukan satu hal sampai selesai, baru melakukan hal lain.
    - Salah satu implementasi Concurrency Programming yang saat ini paling populer adalah Go-Lang Goroutine
    - Untungnya di Kotlin, ada fitur yang bernama Coroutine, salah satu implementasi Concurrency Programming.

    Pengenalan Coroutine
    - Coroutine sering diistilahkan sebagai lightweight thread (thread ringan), walaupun sebenarnya coroutine sendiri
      bukanlah thread.
    - Coroutine sebenarnya di eksekusi di dalam thread, namun dengan coroutine sebuah thread dapat memiliki kemampuan
      untuk menjalankan beberapa coroutine secara bergantian (concurrent).
    - Artinya jika sebuah thread menjalankan 10 coroutine, sebenarnya thread akan menjalankan coroutine satu per satu
      secara bergantian.
    - Perbedaan thread dan coroutine itu murah dan cepat, sehingga kita dapat membuat ribuan atau bahkan jutaan coroutine
      secara cepat dan murah tanpa takut kelebihan memory.

    Suspend function
    - Suspend computation adalah komputasi yang dapat ditangguhkan (ditunda waktu eksekusinya).
    - Sebelumnya kita tahu untuk menangguhkan  komputasi di Java, kita biasanya menggunakan Thread.sleep(), sayangnya
      Thread.sleep() akan mem-block thread yang sedang berjalan saat ini, sehingga tidak bisa digunakan.
    - Kotlin memiliki sebuah fitur bernama suspending function, dimana kita dapat menangguhkan waktu eksekusi sebuah
      function, tanpa harus melakukan block thread yang sedang menjalankannya.
    - Syarat menjalankan suspend function pada Kotlin adalah harus dipanggil dari suspend function lainnya.
    - Dan pada saat membuat coroutine secara default isinya adalah suspend function oleh karena itu dengan membuat coroutine
      kita dapat memanggil semua suspend function.
    - Pengganti Thread.sleep() adalah function delay() dimana function ini adalah suspend function yang berfungsi menunggu
      proses selama sekian miliseconds sesuai dengan parameter yang ditentukan akan tetapi function ini tidak mem-block
      thread yang sedang berjalan, sehingga thread dapat digunakan untuk mengerjakan yang lain.

    Synchronous
    - Secara sederhana Syncronous adalah proses pengeksekusian kode pada program yang dijalankan secara berurutan sesuai
      dengan posisi dari kode yang tertulis pada program tersebut.
    - Contoh :
                fun main(){
                    println("Dettol")  // Dieksekusi pertama
                    println("Biore")    // Dieksekusi kedua
                    println("Citra")    // Dieksekusi ketiga

                }
            ket : - Outputnya akan sesuai urutan code programnya, karena setiap perintah yang dieksekusi harus menunggu
                    terlebih dahulu perintah sebelumnya selesai untuk dapat dieksekusi.
                  - Proses ini dapat juga disebut dengan blocking.
    - Proses syncrhonous dapat dianalogikan seperti proses antrian CS di sebuah bank, dimana nasabah harus menunggu
      terlebih dahulu proses nasabah lain sampai selesai untuk dapat dilayani.

    Asynchronous
    - Asynchronous adalah proses eksekusi kode yang tidak sesuai dengan urutan yang ada dengan kata lain menjalankan
      perintah selanjutnya tanpa menunggu perintah sebelumnya selesai dieksekusi. Proses seperti ini bisa disebut juga
      dengan non-block.
 */
package com.practice

class App {
    // Contohnya di test pengganti Thread

}

