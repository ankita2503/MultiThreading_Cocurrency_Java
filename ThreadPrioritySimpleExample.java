public class ThreadPrioritySimpleExample {


    public static void main(String[] args) {
        Thread t1 = new Thread(new runnable1());
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        System.out.println("Main Thread Finished");
    }


    public static class runnable1 implements Runnable {

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println("runnable1 " + i);
            }
            System.out.println();
        }
    }
}
