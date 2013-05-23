package threading;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t.start();

        try {
            t.join(200); // wait for thread to finish with timeout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Message");

    }

}
