public class DaemonThreadEx {

    public static class DeamonThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Deamon Thread is Running");
                System.out.println("ThreadPriority is " + Thread.currentThread().getPriority());
            }
        }
    }

    public static class NormalThread extends Thread {
        @Override
        public void run() {
            System.out.println("NormalThread is Running");
            System.out.println("ThreadPriority is " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t2 = new NormalThread();
        Thread t1 = new DeamonThread();
        t1.setDaemon(true);
        t1.start();//Daemon Thread finishes its Execution when all normal threads in application is terminated
        t2.start();


    }
}
