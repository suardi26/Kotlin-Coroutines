/**
    Coroutine Parent & Child
    - Selain coroutine scope, coroutine sendiri dapat memiliki child coroutine.
    - Pada saat membuat coroutine child, secara otomatis kita akan mewarisi coroutine context yang ada di coroutine
      parent.
    - Dan Coroutine parent akan menunggu sampai eksekusi coroutine child-nya selesai semua.

 */
package coroutine.parent.and.child

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

