/**
    Sequential Suspend Function
    - Secara default, sebuah suspend function tidaklah async, saat kita mengakses beberapa suspend function, semua akan
      dieksekusi secara sequential (satu persatu).
    - Suspend function sama seperti function biasanya dan tidak ada hubungannya dengan diakses secara Asynchronous,
      namun pada suspend function itu dapat di suspend atau ditangguhkan/dijeda eksekusinya.

    Concurrent Dengan Launch
    - Jadi agar sebuah suspend function dapat berjalan secara concurent, kita perlu menggunakan function launch ketika
      memanggil suspend function tersebut.
    - Hal yang menyulitkan adalah, launch function menggembalikan Job, dan di dalam Job, kita tidak dapat mengembalikan
      nilai hasil dari coroutine.
    - Hal ini dapat dianalogikan bahwa launch itu adalah menjalankan coroutine yang mengembalikan nilai Unit(tidak
      mengembalikan nilai).
    - function "launch" mirip seperti runnable di Thread, dimana tidak mengembalikan nilai.
 */
package sequential.suspend.function

class App {
   // Contohnya di Test
}


