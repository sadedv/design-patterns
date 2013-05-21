package threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) {

        // cached();

        // fixed(); // maximalne tri vlakna subezne

        callable(); // vracia hodnotu

    }

    public static void cached() {

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());

        exec.shutdown();

    }

    public static void fixed() {

        ExecutorService exec = Executors.newFixedThreadPool(3);

        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());
        exec.execute(new Task());

        exec.shutdown();

    }

    public static void callable() {

        ExecutorService exec = Executors.newCachedThreadPool();

        Future<String> future = exec.submit(new CallableTask());
        
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        exec.shutdown();

    }

}
