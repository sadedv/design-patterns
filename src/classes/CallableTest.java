package classes;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {

        String s = new String("thread #" + Thread.currentThread().getId());
        System.out.println("Hello, this is " + s);

        return "returning " + s;
    }

}
