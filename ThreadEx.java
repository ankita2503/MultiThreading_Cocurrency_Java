public class ThreadEx {
        public static void main(String[] args) throws InterruptedException {

            Thread T1 = new runnable1();
            T1.setDaemon(true);

            T1.start();



            Thread T2 = new runnable2();
            T2.start();
            T1.join(); //Wait for Thread T1 to finish



            System.out.println(Thread.currentThread().getName()+" Finished");





        }
    }





