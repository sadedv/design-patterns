package networking.multicast;

public class Test {

    public static void main(String[] args) {
        
        String test = "1.14;5.22";
        
        String[] arr = test.split(";");
        
        double x = Double.parseDouble(arr[0]);
        double y = Double.parseDouble(arr[1]);
        
        System.out.println("x: " + x + ", y: " + y);
        
    }
    
}
