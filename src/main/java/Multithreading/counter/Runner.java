package Multithreading.counter;

/**
 * Created by Aphex on 02.06.2016.
 */
public class Runner {
    public static void execute(){
        Counter.counter=0;
        Counter[] counters = new Counter[100];
        for (Counter counter:counters){
            counter = new Counter();
            counter.start();
        }
        System.out.print("counter = "+Counter.counter);
    }
}
