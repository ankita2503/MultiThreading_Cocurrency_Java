public class SychronizationEx {

    public static int counter1 = 0;
    public static int counter2 = 0;

    //Even though increment1 and increment2 are totally independent methods, The instricsic lock on class forces the other thread to wait for increment1 to be completed.

    public static  void increment1(){
        synchronized(SychronizationEx.class){
            counter1++;
        }
    }

    public static  void increment2(){
        synchronized(SychronizationEx.class){
            counter2++;
        }
    }
    public static class runnable1 implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                increment1();
            }
        }
    }

    public static class runnable2 implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                increment2();
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
        Thread t2 = new Thread(new runnable2());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("end");
        System.out.println("final counter value " + counter1);
        System.out.println("final counter value " + counter2);
    }
}
