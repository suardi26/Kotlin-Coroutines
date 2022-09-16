/**
    Channel
    - Channel adalah fitur di Kotlin Coroutine yang dapat digunakan untuk mentransfer aliran data dari satu tempat
      ke tempat lain, biasanya digunakan untuk mengirim data dari coroutine satu ke coroutine yang lain.
    - Channel mirip struktur data queue, dimana ada data masuk dan ada data keluar.
    - Untuk mengirim data ke channel, kita dapat menggunakan function send() dan untuk mengambil data di channel kita
      dapat menggunakan function receive().
    - Channel itu sifatnya blocking, artinya jika tidak ada data di channel, saat kita mengambil data menggunakan
      receive() maka dia akan menunggu sampai ada data. Dan begitu juga ketika ada data di channel, dan tidak ada
      yang mengambilnya, saat kita send() data, dia akan menunggu sampai channel kosong (datanya diambil).
    - Untuk menutup channel, kita dapat menggunakan function close().

    Channel Backpressure
    Channel Buffer
    - Secara default, channel hanya dapat menampung satu data, artinya jika kita mencoba mengirim data lain ke channel,
      maka kita harus menunggu data yang ada diambil.
    - Namun kita bisa menambahkan buffer di dalam channel atau istilahnya capacity. Jadi default-nya capacity-nya
      adalah 0 (buffer atau antrian yang dapat ditampung).

    Contoh Constant Channel Capacity.
        Constant                Capacity                Keterangan
        - Channel.UNLIMITED     Int.MAX_VALUE           Total kapasitas buffer-nya Int.MAX_VALUE atau bisa dibilang
                                                        unlimited (sekitar 2 Miliar).

        - Channel.RENDEZVOUS    0                       Tidak memiliki buffer.

        - Channel.BUFFER        64 atau bisa di         Total kapasitas buffer-nya 64 atau sesuai properties.
                                setting via properties

        - Channel.CONFLATED     -1                      Pada saat ingin mengirim data, dan data di dalam channel
                                                        masih ada maka data tersebut akan dihapus dan digantikan
                                                        dengan data yang baru.

    Channel Buffer Overflow
    - Walaupun kita sudah menggunakan buffer, ada kalanya buffer sudah penuh, dan sender tetap mengirimkan data.
    - Dalam kasus sepertin ini, kita dapat menggunakan beberapa strategy.
    - Untuk mengatur ketika terjadi buffer overflow (kelebihan data yang ditampung oleh buffer), kita dapat menggunakan
      enum BufferOverflow.

    Beberapa value dari BufferOverflow Enum
        BufferOverflow Enum                 Keterangan
        - SUSPEND(default)                  Block sender.
        - DROP_OLDEST                       Hapus data di buffer yang paling lama (Paling depan), mirip dengan
                                            Channel.CONFLATED.
        - DROP_LATEST                       Hapus data di buffer yang paling baru (Paling belakang) artinya jika data
                                            penuh maka data yang baru dimasukan akan ditolak atau di-ignore.

    Channel Undelivered Element
    - Kadang ada kasus dimana sebuah channel sudah di close, tetapi ada coroutine yang masih mencoba mengirim data ke
      channel.
    - Ketika kita mencoba mengirim data ke channel yang sudah close, maka secara otomatis channel akan mengembalikan
      error ClosedSendChannelException.
    - Namun pertanyaannya, bagaimana dengan data yang sudah dikirim ?.
    - Kita dapat menambah lambda function ketika membuat object channel, sebagai fallback ketika sebuah data dikirim dan
      channel sudah di close, maka fallback tersebut akan dieksekusi.
    - Function fallback tersebut bernama onUndeliveredElement.

    Braadcast Channel
    - Secara default channel hanya boleh memiliki 1 receiver.
    - Namun Kotlin Coroutine mendukung Broadcast Channel, ini adalah channel khusus yang receiver-nya dapat lebih dari
      satu.
    - Setiap kita mengirim data ke channel ini, secara otomatis semua receiver bisa mendapatkan data tersebut.
    - BroadcastChannel memiliki function openSubscription() untuk membuat ReceiveChannel baru.
    - BraodcastChannel tidak mendukung kapasitas buffer 0 dan UNLIMITED.

    broadcast Function
    - Sama seperti produce function, untuk membuat broadcast channel secara langsung dengan coroutine-nya, kita dapat
      menggunakan function broadcast di coroutine scope.
    - Hasil dari broadcast function adalah BroadcastChannel.

    Conflated Broadcast Channel
    - Conflated Broadcast Channel adalah turunan dari Braadcast Channel, sehingga cara kerjanya sama.
    - Pada Broadcast Channel, walaupun receiver lambat, maka receiver tetap akan mendapatkan seluruh data dari sender.
    - Namun berbeda dengan Conflated Broadcast Channel, receiver hanya akan mendapat data paling baru dari sender.
    - Jadi jika receiver lambat, receiver hanya akan mendapat data paling baru saja, bukan semua data.

 */
package channel

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
}
