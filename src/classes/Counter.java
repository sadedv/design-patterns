package classes;

public class Counter implements Runnable {

    private static int counterCount;
    private int id;
    
    public boolean stop = true;
    
    public Counter() {
        id = counterCount++;
    }
    
    @Override
    public void run() {
        
        while (stop) {
            
            System.out.println("Counter " + id + " is running.");
            
        }
        
    }

}
