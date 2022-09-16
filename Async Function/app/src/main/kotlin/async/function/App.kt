/**
    Async Function
    - Untuk membuat coroutine, kita tidak hanya bisa menggunakan function launch, ada juga function async yang dapat kita
      gunakan juga untuk membuat coroutine.
    - Berbeda dengan launch function yang mengembalikan Job, async function mengembalikan Deferred.
    - Deferred adalah turunan dari Job, yang membedakan adalah Deferred membawa value hasil dari async function.
    - Deferred itu mirip konsep Promise atau Future yang ada di Java Thread, dimana datanya akan ada nanti.
    - Jika kita ingin menunggu data di Deferred sampai ada, kita dapat menggunakan method await().
    - jadi launch mirip dengan runnable tidak mengembalikan data, sedangkan Async mirip dengan Callable
      di java Thread dimana mengembalikan data.
 */
package async.function

class App {

}



