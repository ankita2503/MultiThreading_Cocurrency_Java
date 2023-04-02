package ThreadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    static int i = 0;

    public static void main(String[] args) {
        Task task = new Task();
        //Single Thread that will execute sequentially
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(task);
        }
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread with name " + Thread.currentThread().getName() + " and ID : + " + Thread.currentThread().getId() + " and i : + " + i++);
        }
    }

}

