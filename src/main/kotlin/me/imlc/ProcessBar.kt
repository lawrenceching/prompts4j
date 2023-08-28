package me.imlc

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.atomic.AtomicBoolean

class ProcessBar {

    private val shouldStop = AtomicBoolean(false)

    fun start() {
        shouldStop.set(false)
        ForkJoinPool.commonPool().submit(object : Runnable {
            override fun run() {
                var i = 0;
                while(!shouldStop.get() && i < 100) {
                    print("#".repeat(i++))
                    print('\r')
                    Thread.sleep(200)
                }
            }
        })

    }

    fun stop() {
        shouldStop.set(true)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val processBar = ProcessBar()
            processBar.start()
            Thread.sleep(10000)
            processBar.stop()
        }
    }

}