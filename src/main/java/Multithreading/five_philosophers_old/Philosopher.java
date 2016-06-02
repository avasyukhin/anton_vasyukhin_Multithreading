package Multithreading.five_philosophers_old;

import java.util.Random;

/**
 * Created by Aphex on 02.06.2016.
 */
public class Philosopher extends Thread {
    Fork left;
    Fork right;
    int id;

    public Philosopher(int id,Fork left, Fork right) {
        this.id=id;
        this.left = left;
        this.right = right;
    }
    public void run(){
        int leftID = left.id;
        int rightID = right.id;
        Fork first=null, second=null;
        if (leftID<rightID){
            first=left; second=right;
        }else{
            second=left;first=right;
        }
        Random generator = new Random();
        try {
            while (true){
                synchronized (first){
                    synchronized (second){
                        eat(generator.nextInt(6000));
                    }
                }
                think(generator.nextInt(6000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    private void eat(long time) throws InterruptedException {
        System.out.println("Philosopher "+id+" EAT");
        sleep(time);
    }
    private void think(long time) throws InterruptedException {
        System.out.println("Philosopher "+id+" THINKING");
        sleep(time);
    }
}
