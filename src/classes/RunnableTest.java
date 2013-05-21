package classes;

public class RunnableTest implements Runnable {

    @Override
    public void run() {

        System.out.println("Message 1 from " + Thread.currentThread().getId());
        Thread.yield();

        System.out.println("Message 2 from " + Thread.currentThread().getId());
        Thread.yield();

        System.out.println("Message 3 from " + Thread.currentThread().getId());
        Thread.yield();

    }

    public static void main(String[] args) {

        new Thread(new RunnableTest()).start();
        new Thread(new RunnableTest()).start();
        new Thread(new RunnableTest()).start();

    }

}
