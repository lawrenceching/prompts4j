package me.imlc

import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder


class Password {

    fun password(prompt: String): String? {
        return Password.password(prompt)
    }


    companion object {

        fun password(prompt: String): String? {
            val preferJline = System.getenv("PREFER_JLINE")?.toBooleanStrict() ?: false

            if (preferJline) {
                var terminal: Terminal? = null;
                var reader: LineReader? = null;
                try {
                    terminal = TerminalBuilder.terminal()
                    reader = LineReaderBuilder.builder().terminal(terminal).build()
                    val password = reader.readLine(prompt, '*')
                    return password
                } finally {
                    terminal?.close()
                }
            } else {
                return String(System.console().readPassword(prompt))
            }
        }


        @JvmStatic
        fun main(args: Array<String>) {
            println("Password: ${password("Enter your password: ")}")
        }
    }
}