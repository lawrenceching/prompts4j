package me.imlc;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.Signals;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Terminal terminal = TerminalBuilder.terminal();

        Signals.register("WINCH", new Runnable() {
            @Override
            public void run() {
                int width = terminal.getWidth();
                int height = terminal.getHeight();
                System.out.println(String.format("received SIGWINCH: lines=%d, columns=%d", height, width));
            }
        });

        Thread.sleep(100000);

    }
}