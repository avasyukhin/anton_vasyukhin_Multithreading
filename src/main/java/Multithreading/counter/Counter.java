package Multithreading.counter;

/**
 * Created by Aphex on 24.05.2016.
 */
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter extends Thread {
    public static AtomicInteger counter;
    public void run() {
        for (int i = 0; i< 100000; i++){
            counter.compareAndSet(counter.get(),counter.addAndGet(1));
        }
    }
}
