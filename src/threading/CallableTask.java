package threading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(2000);
        return "Thread #" + Thread.currentThread().getId();
    }
    
}
