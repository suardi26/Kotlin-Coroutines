/**
    Cancellable Coroutine
    - Job dapat kita batalkan menggunakan function cancel.
    - Membatalkan coroutine kadang diperlukan, misal ketika kode program di coroutine terlalu lama.
    - Semua function yang ada di package kotlinx.coroutines dapat dibatalkan.
    - Namun, jika dalam kode program kita, kita tidak mengecek status cancel, maka coroutine yang kita buat tidak akan
      dapat dibatalkan.

    Agar Coroutine dapat dibatalkan
    - Untuk mengecek apakah coroutine masih aktif atau tidak (selesai / dibatalkan), kita dapat menggunakan field "isActive"
      milik CoroutineScope.
    - Untuk menandakan bahwa coroutine dibatalkan, kita bisa throw CancellationException.

    Setelah Coroutine di Cancel.
    - Standard coroutine adalah ketika sebuah coroutine dibatalkan, maka kita perlu throw CancellableException.
    - Karena throw CancelableException, artinya jika kita ingin melakukan sesuatu ketika sebuah coroutine dibatalkan,
      kita dapat menggunakan block try-finally.
 */
package cancellable.coroutine

class App {

}
