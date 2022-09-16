/**
    Coroutine Context
    - Coroutine selalu berjalan dibarengi dengan object CoroutineContext.
    - CoroutineContex adalah sebuah kumpulan data CoroutineContext.Element, yang paling utama contohnya adalah
      Job(turunan dari CoroutineContext.Element) dan CoroutineDispatcher.

    Menggabungkan Context Element
    - CoroutineContext adalah kumpulan dari Element-Element, contoh turunannya adalah Job, CoroutineDispatcher dan
      CoroutineName.
    - CoroutineContext memiliki function plus, sehingga sebenarnya kita dapat menggabungkan beberapa context element
      secara sekaligus, misal Dispatcher dan CoroutineName.
 */
package coroutine.context

class App {
   // Contohnya ada di Test.
}


