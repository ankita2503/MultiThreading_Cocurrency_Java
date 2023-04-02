package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    public static int counter = 0;
    static Lock lock = new ReentrantLock();



    public static void increment1() {

        try{
            lock.lock();
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    public static void increment2() {
        try{
            lock.lock();
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock(); // to prevent deadlock in case of an exception
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);

        System.out.println("Execution End");


    }


}
