/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempi;

/**
 *
 * @author Paolo
 */
import java.util.Timer;
import java.util.TimerTask;

public class time {

    static long interval;
    static Timer timer;

    static long minuti;
    static long secondi;

    public static void cooldown() {

        long milli = 60000;
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = milli;
        minuti = interval / (1000 * 60);
        secondi = interval / 1000;
        System.out.println(minuti + " " + secondi);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                System.out.println(minuti + " " + secondi);
                setInterval();

            }
        }, delay, period);
    }

    private static final long setInterval() {
        if (secondi == 1) {
            secondi = 60;

            return  minuti--;

        }
        return secondi--;
    }
}
