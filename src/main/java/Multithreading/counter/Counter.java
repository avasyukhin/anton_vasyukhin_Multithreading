package Multithreading.counter;

/**
 * Created by Aphex on 24.05.2016.
 */
import java.lang.Thread;
public class Counter extends Thread {
    static volatile int counter;
    public void run() {
        for (int i = 0; i< 100000; i++){
            counter++;
        }
    }
}
