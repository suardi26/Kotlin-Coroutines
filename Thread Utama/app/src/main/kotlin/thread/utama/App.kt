/**
    Thread Utama
    - Pada saat kita menjalankan sebuah process (aplikasi) Kotlin pada JVM, secara otomatis Proses tersebut akan jalan
      pada sebuah thread utama.
    - Thread utama tersebut bernama "main" thread (JVM).
    - Saat kita menjalankan process JUnit, JUnit pun berjalan di thread tersendiri yang namanya "Test worker".
    - Begitu juga kita membuat aplikasi kotlin Android, aplikasi tersebut akan berjalan di sebuah thread.
    - Untuk mengetahui kita running di Thread mana, maka kita dapat menggunakan perintah :
        "val threadName = Thread.currentThread().name"
        "println(threadName)"
 */
package thread.utama

class App {


}

fun main(){
    val threadName = Thread.currentThread().name
    println(threadName)
}

