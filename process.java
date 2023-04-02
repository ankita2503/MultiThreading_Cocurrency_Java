public class process {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Produce started");
            wait();
            System.out.println("produced input is sucessfully consumed");

        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            System.out.println("Consume started");
            Thread.sleep(1000);
            System.out.println("Consume End");
            notify();
        }
    }
}
