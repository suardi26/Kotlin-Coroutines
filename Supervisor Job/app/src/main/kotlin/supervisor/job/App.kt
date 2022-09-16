/**
    Supervisor Job
    - Secara default, saat kita membuat coroutine scope atau menjalankan coroutine, tipe coroutine tersebut adalah Job.
    - Dalam Job, saat terjadi error di salah satu coroutine, maka error tersebut akan di propagate ke parent-nya.
    - Dan secara otomatis parent akan membatalkan semua coroutine.

    - Supervisor job adalah tipe job lainnya.
    - Supervisor job dapat menjadikan setiap coroutine memiliki kemampuan untuk error secara mandiri.
    - Hal ini berakibat jika ada coroutine error, parent tidak akan membatalkan seluruh coroutine yang lain.
    - Supervisor job adalah turunan dari Job.
 */
package supervisor.job

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

