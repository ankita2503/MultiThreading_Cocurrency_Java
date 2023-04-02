package ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueExample {

    private static final int QUEUE_CAPACITY = 10;

    static int i=0;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);


        new Thread(()->{
            while(true){
                try {
                    int value = blockingQueue.take();
                    System.out.println("Consuming");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

        new Thread(()->{
            while(true){
                try {
                    for (int i = 1; i <= QUEUE_CAPACITY; i++) {
                        blockingQueue.put(i);
                        System.out.println("Produced: " + i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

    }
}
