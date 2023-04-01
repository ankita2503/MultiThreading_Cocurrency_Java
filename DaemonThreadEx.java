public class DaemonThreadEx {

    public static class DeamonThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Deamon Thread is Running");
            }
        }
    }

    public static class NormalThread extends Thread {
        @Override
        public void run() {
            System.out.println("NormalThread is Running");
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
