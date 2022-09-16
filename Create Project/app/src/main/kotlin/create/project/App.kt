/**
Parallel Programming
    - Pada saat ini kita hidup di era Multicore, dimana jarang sekali kita menggunakan processor yang single core.
    - Semakin canggih perangkat keras, maka software pun akan mengikuti , dimana sekarang kita dapat dengan mudah
      membuat proses parallel di aplikasi.
    - Parallel Programing sederhananya adalah memecahkan suatu masalah dengan cara membaginya menjadi lebih kecil,
      dan dijalankan secara bersamaan pada waktu yang bersamaan juga.

Contoh Proses Parallel
    - Menjalankan beberapa aplikasi sekaligus di sistem operasi kita misalnya (ms. office, editor, browser, dll)
    - Beberapa Koki menyiapkan makanan di restoran, dimana tiap koki membuat makanan masing-masing.
    - Antrian Pada Bank, dimana tiap teller melayani nasabahnya masing-masing.

Process vs Thread
    - Secara low level ada 2 konsep yang pertama Process dan Thread.
    - Jadi Ketika kita melakukan proses parallel maka ada 2 konsep yaitu Process dan Thread.
        - Process
            - Process adalah sebuah eksekusi program, contoh pada saat running aplikasi ms. word itu
              adalah process atau jika kita menjalankan suatu aplikasi itu adalah process.
            - Process mengkonsumsi memory besar dikarenakan kita akan menjalankan suatu aplikasi.
            - Process saling terisolasi dengan proses lain, jadi process tidak saling berhubungan dengan Process
              lainnya.
            - Process lama untuk dijalankan dan dihentikan.

        - Thread
            - Thread adalah segmen dari process, dan 1 Program yang dirunning(Process) dapat membuat lebih
              dari 1 Thread, dan secara default Process memiliki 1 Thread, namun 1 Process dapat menjalankan
              beberapa Thread.
            - Thread menggunakan memory kecil karena dalam suatu Process kita membuat beberapa Thread bahkan
              sampai ratusan Thread sehingga mengkonsumsi memory kecil, biasanya ukurannya mengikuti Sistem
              Operasinya, kalau Sistem Operasinya 32-bit maka 1 Thread menggunakan memory sekitar 512kb (Thread JVM),
              kalau misal Sistem Operasinya 64-bit maka 1 Thread menggunakan memory sekitar 1MB (Thread JVM)  .
            - Thread dapat saling berhubungan jika dalam process yang sama.
            - Thread cepat untuk dijalankan dan dihentikan.
 */
package create.project

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
