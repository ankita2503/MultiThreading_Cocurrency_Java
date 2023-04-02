package CallableAndFuture;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample implements Callable<String> {

    private int id;

    public CallableExample(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "ThreadName: " +Thread.currentThread().getName()+ " ID : " + id;
    }


    public static void main(String[] args) {
        List<Future> list = new ArrayList<>();
        ExecutorService ExecutorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            Future<String> future = ExecutorService.submit(new CallableExample(i));
            list.add(future);
        }
        list.forEach(i-> {
            try {
                System.out.println(i.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        ExecutorService.shutdown();
    }


}
