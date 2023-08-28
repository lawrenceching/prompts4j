package me.imlc

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.atomic.AtomicBoolean

class Spinner {

    private val shouldStop = AtomicBoolean(false)

    private val flames = arrayOf('-', '\\', '|', '/')

    fun start() {
        shouldStop.set(false)
        ForkJoinPool.commonPool().submit(object : Runnable {
            override fun run() {
                var i = 0;
                while(!shouldStop.get()) {
                    print(flames[i])
                    print('\r')
                    i = (i + 1) % flames.size
                    Thread.sleep(500)
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
            val spinner = Spinner()
            spinner.start()
            Thread.sleep(10000)
            spinner.stop()
        }
    }
}