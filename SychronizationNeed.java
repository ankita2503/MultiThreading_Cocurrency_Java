public class SychronizationNeed {

    public static int counter = 0;

    public static class runnable1 implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
        }
    }

    public static class runnable2 implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                counter++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new runnable1());
        Thread t2 = new Thread(new runnable1());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("end");
        System.out.println("final counter value " + counter); //Counter value will not be consistent and correct
    }
}
