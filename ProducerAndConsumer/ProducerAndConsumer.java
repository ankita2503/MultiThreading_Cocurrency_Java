package ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumer {

    List<Integer> list = new ArrayList<>();

    static Object obj = new Object();

    static int LOWER_LIMIT = 0;
    static int UPPER_LIMIT = 5;
    int i = 0;

    public void producer() throws InterruptedException {
        synchronized (obj) {

            while (true) {
                System.out.println("Inside Producer");
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("produce is full");
                    obj.wait();//Only this statement releases the lock and hence T2 can access the lock
                } else {
                    System.out.println("Producer is producing");
                    list.add(i++);
                    obj.notify();//This notify will not immeditaely the other thread but continue with further operations
                    // When notify() is called, the awakened thread remains blocked until it can acquire the lock on the object's monitor.
                    // If another thread holds the lock at the time notify() is called, the awakened thread must wait for the lock to become available.
                    // Once the awakened thread acquires the lock, it can continue its execution from where it was blocked.
                }
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (obj) {

            while (true) {
                System.out.println("Inside Consumer");
                if (list.isEmpty()) {
                    System.out.println("Nothing to consume");
                    obj.wait(); //Only this statement releases the lock and hence T1 can access the lock
                } else {
                    list.remove(list.size() - 1);
                    System.out.println("Consumer is consuming. remaining item is :" + list.size());
                    obj.notify();//This notify will not immeditaely the other thread but continue with further operations
                    // When notify() is called, the awakened thread remains blocked until it can acquire the lock on the object's monitor.
                    // If another thread holds the lock at the time notify() is called, the awakened thread must wait for the lock to become available.
                    // Once the awakened thread acquires the lock, it can continue its execution from where it was blocked.
                }
            }
        }
    }


}
