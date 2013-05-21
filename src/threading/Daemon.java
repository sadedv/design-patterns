package threading;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {

    @Override
    public void run() {

        while (true) {
        
            System.out.println("Daemon.");

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
