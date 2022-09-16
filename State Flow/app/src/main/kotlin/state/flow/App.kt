/**
    State Flow
    - State Flow adalah turunan dari Shared Flow, artinya di State Flow, kita bisa membuat banyak receiver.
    - Pada State Flow, receiver hanya akan menerima data paling baru.
    - Jadi jika ada receiver yang sangat lambat dan sender mengirim data terlalu cepat, maka yang akan diterima oleh
      receiver adalah data paling akhir.
    - State Flow juga cocok digunakan untuk maintain state, dimana memang biasanya state itu biasanya hanya satu data,
      tidak peduli berapa kali perubahan data tersebut, yang paling penting pada state adalah data terakhir.
    - Untuk mendapatkan data state-nya, kita dapat menggunakan field value di State Flow.
    - Untuk membuat receiver kita bisa menggunakan asStateFlow()
    - State Flow bisa dirancang sebagai pengganti ConflatedBroadcastChannel.
 */
package state.flow

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
