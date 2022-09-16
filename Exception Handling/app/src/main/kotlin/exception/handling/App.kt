/**
    Exception Handling
    - Secara garis besar, Exception di coroutine itu ada yang di ekspose ke yang memanggil coroutine, ada juga yang tidak.
    - Pada launch, exception tidak akan di Ekspose ketika memanggil function join dari job-nya, namun pada async
      exception akan di expose ketika memanggil function await.

    Coroutine Exception Handler
    - Kadang kita ingin mengatur cara penangkapan exception di coroutine, hal ini dapat dilakukan dengan menggunakan
      interface CoroutineExceptionHandler.
    - CoroutineExceptionHandler adalah turunan dari CoroutineContext.Element, sehingga kita dapat menambahkannya
      kedalam coroutine context.
    - Ingat jenis CancellationException (dan turunannya) maka tidak akan diteruskan ke exception handler.
    - Coroutine exception handler hanya jalan di launch, tidak jalan di async/Deferred, untuk async/Deferred, kita tetap
      harus menangkap
      exception-nya secara manual.
    - Exception Handler adalah sebuah interface yang memungkinkan untuk melakukan penanganan Exception tanpa harus manual
      menggunakan try-catch.

    Exception Handler pada Job dan Supervisor Job.
    - Exception handler di Job ataupun di Supervisor Job secara default akan dipropagate ke parent-nya.
    - Artinya jika kita membuat CoroutineExceptionHandler, kita harus membuatnya di parent, tidak dapat di coroutine
      child-nya.
    - Jika kita menambahkan exception handler di coroutine child-nya, maka itu tidak akan pernah digunakan.

    Exception Handler dengan supervisorScope
    - Salah satu cara agar exception handler dapat dilakukan di coroutine child adalah dengan menggunakan
      supervisorScope.
    - Saat menggunakan supervisorScope, maka exception dapat digunakan pada parent coroutine di supervisorScope, atau
      sebenarnya coroutine child di scope yang ada diatasnya.
    - Tapi ingat jika terjadi erorr di child-nya coroutine yang ada di supervisorScope, maka tetap akan di propagate
      ke parent coroutine di supervisorScope.
 */
package exception.handling

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
