package ConcurrentCollections;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample implements Runnable {

    private int id;
    private Random random;
    private CyclicBarrier barrier;

    public CyclicBarrierExample(int id, CyclicBarrier barrier) {
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Thread with ID : " + id + " starts the work....");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            //When the specified count of threads have called await(), the barrier is tripped and all threads are released and allowed to proceed.
            barrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        //Creates a new CyclicBarrier that will trip when the given number of parties (threads) are waiting upon it, and which will execute the given barrier action when the barrier is tripped, performed by the last thread entering the barrier.
        System.out.println("Await is finished..");

    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable(){
            @Override
            public void run() {
                System.out.println("All tasks are finished");
            }
        });

        for (int i = 0; i <5 ; i++) {
            executorService.execute(new CyclicBarrierExample(i+1,barrier));
        }

        executorService.shutdown();
    }

}
