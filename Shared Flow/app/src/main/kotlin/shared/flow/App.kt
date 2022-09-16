/**
    Shared Flow vs Flow
    - Shared Flow adalah turunan dari Flow, sehingga apa yang dapat dilakukan di Flow, bisa juga dilakukan di Shared Flow.
    - Kemampuan Shared Flow yang tidak dimiliki oleh Flow adalah pada Shared Flow, kita bisa membuat lebih dari satu
      receiver.
    - Selain itu Shared Flow bersifat aktif atau hot, yang artinya ketika kita mengirim data ke Shared Flow, data
      langsung dikirim ke receiver tanpa perlu di collect terlebih dahulu oleh si receiver.

    Shared Flow vs Broadcast Channel
    - Shared Flow mulai dikenalkan di Kotlin 1.4.
    - Share Flow dirancang sebagai pengganti Broadcast Channel.
    - Shared Flow adalah turunan dari Flow, sehingga mendukung semua Flow operator, hal ini yang sangat membedakan
      dengan Channel yang hanya bisa menggunakan receive() untuk menerima data, di Shared Flow, kita bisa melakukan
      operasi apapun bawaan dari Flow operator.
    - Shared Flow mendukung configurable buffer overflow strategy karena dapat menggunakan Flow Operator.
    - Shared Flow bukanlah channel, sehingga tidak ada operasi close.
    - Untuk membuat receiver dari Shared Flow, kita dapat menggunakan function asSharedFlow(), mirip seperti function
      openSubscription() yang ada pada Broadcast Channel.

 */

package shared.flow

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
