package Multithreading.five_philosophers_concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aphex on 02.06.2016.
 */
public class Fork {
    private static Random generator = new Random();
    private Semaphore sem = new Semaphore(1,true);

    public boolean pickUp(){
        try {
            return sem.tryAcquire(1, generator.nextInt(600), TimeUnit.MILLISECONDS);
        } catch(InterruptedException e) {
            return false;
        }
    }

    public void putDown(){
        sem.release();
    }
}
