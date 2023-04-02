package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public void worker1() {
        try {
            System.out.println("worker1 acquired lock1..");
            lock1.lock();

            Thread.sleep(300);

            lock2.lock();
            System.out.println("worker1 acquired lock2..");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void worker2() {
        try {
            System.out.println("worker2 acquired lock2..");
            lock2.lock();
            Thread.sleep(300);

            lock1.lock();
            System.out.println("worker2 acquired lock1..");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } finally {
            lock1.unlock();
            lock2.unlock();
        }

    }

    public static void main(String[] args) {
        DeadlockExample DeadlockExample = new DeadlockExample();
        new Thread(DeadlockExample::worker1, "worker1").start();
        new Thread(DeadlockExample::worker2, "worker2").start();

    }
}
