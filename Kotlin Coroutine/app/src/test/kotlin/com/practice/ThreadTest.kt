package com.practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.*


class ThreadTest {

    // membuat suspend function
    suspend fun helloWord(){
        println("Hello : ${Date()} : ${Thread.currentThread().name}")
        delay(2_000) // Pengganti function Thread.sleep()
        println("World : ${Date()} : ${Thread.currentThread().name}")
    }

    @Test
    fun testSuspendFunction(){

        // digunakan untuk running coroutine tapi melakukan block pada thread-nya.
        runBlocking {
            helloWord()
        }
    }
}