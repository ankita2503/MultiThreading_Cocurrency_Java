public class ThreadExample extends Thread {
    private int count;

    public ThreadExample(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + " counting: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample(5);
        ThreadExample thread2 = new ThreadExample(10);

        thread1.start();
        thread2.start();
    }
}
