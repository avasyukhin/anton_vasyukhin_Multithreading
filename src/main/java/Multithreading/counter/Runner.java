package Multithreading.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aphex on 02.06.2016.
 */
public class Runner{
    public static void execute (){
        Counter.counter=new AtomicInteger(0);
        Counter[] counters = new Counter[100];
        for (Counter counter:counters){
            counter = new Counter();
            counter.start();
            try {
                counter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("counter = " + Counter.counter);
    }
}
