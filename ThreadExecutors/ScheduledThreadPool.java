package ThreadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        StockMarketUpdater task = new StockMarketUpdater();
        //Single Thread that will execute sequentially
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 2000, TimeUnit.MILLISECONDS);
        try {
            for (int i = 0; i < 5; i++) {
                executorService.execute(task);
            }
            //Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
            executorService.shutdown();

            //Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                //Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
        }
    }

    public static class StockMarketUpdater implements Runnable {

        @Override
        public void run() {
            System.out.println("Updating and Downloading data from web...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

