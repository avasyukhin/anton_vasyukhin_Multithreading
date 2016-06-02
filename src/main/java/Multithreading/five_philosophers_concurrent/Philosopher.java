package Multithreading.five_philosophers_concurrent;


import java.util.Random;


/**
 * Created by Aphex on 02.06.2016.
 */
public class Philosopher extends Thread {
    Fork left;
    Fork right;
    int id;


    public Philosopher(int id, Fork left, Fork right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    public void run() {
        Random generator = new Random();
        try {
            while (true) {
                doEat(generator.nextInt(6000));
                think(generator.nextInt(6000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void doEat(int time) throws InterruptedException {
        if (left.pickUp()) {
            if (right.pickUp()) {
                eat(time);
                left.putDown();
                right.putDown();
            } else {
                left.putDown();
                doEat(time);
            }
        }
    }


    private void eat(long time) throws InterruptedException {
        System.out.println("Philosopher " + id + " EAT");
        sleep(time);
    }

    private void think(long time) throws InterruptedException {
        System.out.println("Philosopher " + id + " THINKING");
        sleep(time);
    }
}
