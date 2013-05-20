package classes;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        Future<String> a1 = exec.submit(new CallableTest());
        Future<String> a2 = exec.submit(new CallableTest());
        Future<String> a3 = exec.submit(new CallableTest());
        
        exec.shutdown();
        
        try {
            System.out.println(a1.get());
            System.out.println(a2.get());
            System.out.println(a3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }

}
