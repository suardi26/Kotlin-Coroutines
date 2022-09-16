/**
    Coroutine Scope Parent & Child
    - Pada saat kita membuat sebuah coroutine scope dengan menggunakan function coroutineScope, sebenarnya kita telah
      membuat child scope dari parent scope-nya atau dari yang memanggil function coroutineScope-nya.
    - Coroutine scope itu saling berkaitan antara parent dan child-nya.
    - Saat kita membuat child scope, secara otomatis child scope akan menggunakan CoroutineContext milik parent
      misalnya dispatcher.
    - Dan saat kita membatalkan parent scope, maka semua child scope-nya pun akan dibatalkan.
 */
package coroutine.scope

class App {
   // Contohnya ada di bagian Test.
}

