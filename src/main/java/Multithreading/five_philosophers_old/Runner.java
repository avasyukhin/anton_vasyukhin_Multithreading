package Multithreading.five_philosophers_old;

/**
 * Created by Aphex on 02.06.2016.
 */
public class Runner {
    public static void execute(){
        int N=5;
        Fork[] forks= new Fork[N];
        Philosopher[] philosophers = new Philosopher[N];
        for (int i = 0; i<N;i++){
            forks[i]=new Fork(i);
        }
        for (int i = 0; i<N;i++){
            philosophers[i]=new Philosopher(i,forks[i],forks[(i+1)/N]);
        }
        for (int i = 0; i<N;i++){
            philosophers[i].start();
        }
    }
}
