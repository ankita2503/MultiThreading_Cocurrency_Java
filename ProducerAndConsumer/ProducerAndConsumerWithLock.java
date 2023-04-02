package ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerWithLock {

    List<Integer> list = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    Object obj = new Object();

    public void producer() throws InterruptedException {

        while(true) {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Producer is Producing");
            condition.await(); // await for consumer
        }

    }

    public void consumer() throws InterruptedException {
        Thread.sleep(3000);// So that producer can start first
        while(true) {
            lock.lock();
            System.out.println("Consuming is consuming");
            condition.signal();//signal await to resume
            lock.unlock();
            Thread.sleep(1000);
        }

    }



}
