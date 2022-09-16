/**
    withContext Function
    - Sebelumnya kita sudah tau, bahwa ternyata saat kita melakukan delay(), suspend function tersebut akan di trigger
      di thread yang berbeda.
    - Bagaimana caranya jika kita ingin menjalankan code program kita dalam coroutine di thread yang berbeda dengan
      thread coroutine awalnya ?
    - Untuk melakukan itu, kita dapat menggunakan function withContext()
    - Function with Context() sebenarnya bisa kita gunakan untuk mengganti CoroutineContext, namun karena
      CoroutineDispatcher adalah turunan CoroutineContext, jadi kita dapat otomatis mengganti thread yang akan digunakan
      di coroutine menggunakan function withContext().
 */
package withcontext.function

class App {
   // Contohnya ada di bagian Test
}

