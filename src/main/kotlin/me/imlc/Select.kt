package me.imlc

import org.jline.terminal.TerminalBuilder
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import kotlin.text.StringBuilder

class Select {

    companion object {

        fun renderOptions(option: Array<String>, selectedIndex: Int): String {
            var sb = StringBuilder()

            for (i in 0..option.size-1) {
                sb.append("${if(i == selectedIndex) "*" else " "} ${option[i]}")

                if(i != option.size - 1) {
                    sb.appendLine()
                }
            }

            return sb.toString()
        }

        fun select(): String {
            val terminal = TerminalBuilder.builder().build()
            terminal.enterRawMode()

            val reader = terminal.reader()
            val writer = terminal.writer()


            val options = arrayOf(
                "A",
                "B"
            )



            var prompt = ""

            var selectedOption = 0
            try {
                return "FFF"

                val buf = CharArray(8)
                val input = CharArray(156)

                while(true) {


                    if(prompt.length != 0) {
                        writer.print("${ASCII_ESC}[1A${ASCII_ESC}[0G${ASCII_ESC}[${prompt.length}K")
                    }

                    writer.flush()
                    prompt = renderOptions(options, selectedOption)
                    writer.print(prompt)
                    writer.flush()

                    reader.read(buf)

                    CharUtil.copyTo(buf, input)

                    if(buf[0]== ASCII_RETURN) {
                        return options[selectedOption]
                    }

                    if(CharUtil.equals(input, CONTROL_CODE_ARROW_DOWN)) {
                        selectedOption = if(selectedOption + 1 > options.size - 1) options.size else selectedOption + 1
                        input.fill(ASCII_NULL)
                    }

                    if(CharUtil.equals(input, CONTROL_CODE_ARROW_UP)) {
                        selectedOption = if(selectedOption - 1 > options.size - 1) options.size else selectedOption - 1
                        input.fill(ASCII_NULL)
                    }

                }

            } finally {
                reader.close()
                writer.close()
                terminal.close()
            }


        }

        fun getString(): String {
            val terminal = TerminalBuilder.builder().build()
            terminal.enterRawMode()
            val writer = terminal.writer()
            val reader = terminal.reader()
            try {
                println("BBBAFSDSA")
                return "AAA"
            } finally {
                writer.close()
                reader.close()
                terminal.close()
            }

        }

        @JvmStatic
        fun main(args: Array<String>) {
//            println("You selected ${select()}")

//            println(getString())
            val terminal = TerminalBuilder.builder().build()
            val writer = terminal.writer()
            writer.close()
            terminal.close()
            println("AAA")


        }
    }

}