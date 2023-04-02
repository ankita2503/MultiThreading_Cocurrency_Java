package ProducerAndConsumer;

public class ProducerAndConsumerWithLockImpl {

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumerWithLock ProducerAndConsumerWithLock = new ProducerAndConsumerWithLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ProducerAndConsumerWithLock.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ProducerAndConsumerWithLock.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
