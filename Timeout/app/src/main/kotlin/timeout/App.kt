/**
    Timeout
    - Kadang kita ingin sebuah coroutine berjalan tidak lebih dari waktu yang telah ditentukan.
    - Sebenarnya kita dapat melakukan hal tersebut secara manual, dengan cara menjalankan 2 job,
      dimana job ke dua akan membatalkan job pertama jika job pertama terlalu lama.
    - Namun hal ini tidak perlu lagi, terdapat function withTimeout untuk melakukan hal tersebut.
    - Jika terjadi timeout melebihi waktu yang telah kita tentukan, maka secara otomatis function
      withTimeout akan throw TimeoutCancellationException, dimana Exception ini adalah turunan dari
      CancellationException sehingga ketika coroutine kena Timeout maka coroutine tersebut akan
      dibatalkan.

    Timeout Tanpa Membatalkan Coroutine
    - withTimeout akan throw TimeoutCancellationException, dimana itu adalah turunan dari CancellationException.
    - Hal ini berakibat coroutine akan berhenti karena kita throw exception.
    - Jika ada kasus dimana kita tidak ingin menghentikan coroutine-nya, kita bisa menggunakan function withTimeoutOrNull,
      dimana ini tidak akan throw exception, hanya mengembalikan null jika terjadi timeout.
 */
package timeout

class App {
   // Contohnya di bagian Test
}

