import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    enum downloader {
        INSTANCE;

        //Semaphores are often used to restrict the number of threads than can access some (physical or logical) resource.
        // For example, here is a class that uses a semaphore to control access to a pool of items:
    private static Semaphore semaphore = new Semaphore(5, true); // Total 5 different threads can download data at the same time with .

    public static void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private static void downloadData() {
        try {
            Thread.sleep(2000);
            System.out.println("Downloading data from the web");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    downloader.INSTANCE.download();
                }
            });
        }

    }
}
