package ConcurrentCollections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchExample implements Runnable {
    int i = 0;
    static CountDownLatch latch = new CountDownLatch(5);

    @Override
    public void run() {
        System.out.println("Thread with ID : " + Thread.currentThread().getId() + " and latch = " + latch.getCount());
        try {
            Thread.sleep(500);
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LatchExample());
        }
        latch.await();
        System.out.println("All tasks are finished");

        executorService.shutdown();
    }

}
