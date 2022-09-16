/**
    Asynchronous Flow
    - Kita sudah mengetahui bahwa coroutine yang tidak mengembalikan value itu (launch) dan yang mengembalikan satu
      value itu (async), dan bagaimana jika kita butuh sebuah coroutine yang mengembalikan data berkali-kali seperti
      layaknya collection ?
    - Kotlin mendukung hal tersebut dengan nama Flow.
    - Flow mirip dengan sequence di Kotlin Collection, yang membedakan adalah flow berjalan sebagai coroutine dan
      kita dapat menggunakan suspend function di flow.
    - Flow adalah collection cold atau lazy, artinya jika tidak diminta datanya, flow tidak akan berjalan
      (code-nya tidak akan dieksekusi).
    - Jenis Coroutine (launch, async, Flow, dll).

    Membuat Flow
    - Untuk membuat flow, kita dapat menggunakan function flow()
    - Di dalam flow untuk mengirim data kita dapat menggunakan function emit().
    - Untuk mengakses data yang ada di flow, kita dapat menggunakan function collect().
    - Ketika memanggil function collect() untuk mengakses data yang ada di flow, maka flow akan berjalan namun ketika
      belum memanggil collect() maka flow-nya tidak akan berjalan.

    Flow Operator
    - Flow mirip dengan Kotlin Collection, memiliki banyak operator.
    - Hampir semua operator yang ada di Kotlin Collection ada juga di Flow, seperti map, flatMap, filter, reduce, dll.
    - Yang membedakan dengan operator yang ada di Kotlin Collection adalah, operator di Flow mendukung suspend function.

    Flow Exeption
    - Saat terjadi exception pada flow, dibagian operator apapun, maka flow akan berhenti, lalu exception akan di throw
      oleh flow.
    - Untuk menangkap exception tersebut, kita dapat menggunakan block try-catch.
    - Namun flow juga menyediakan operator untuk menangkap exception tersebut, nama function-nya adalah catch().
    - Dan untuk finally, flow juga sudah menyediakan operatornya, nama function-nya adalah onCompletion().
    - Namun perlu diingat, jika terjadi error di flow, flow akan dihentikan , jika kita ingin flow tidak berhenti saat
      terjadi error, pastikan kita selalu melakukan try catch di kode flow-nya.

    Cancellable Flow
    - Flow adalah coroutine, artinya dia dapat dibatalkan.
    - Untuk membatalkan flow, caranya sangat mudah, kita dapat menggunakan function cancel() milik coroutine scope,
      function cancel() teresebut akan secara otomatis membatalkan job coroutine.
 */
package asynchronous.flow

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
