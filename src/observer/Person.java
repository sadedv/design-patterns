package observer;

public class Person implements Observer {

    private String name;

    public Person(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String status) {
        System.out.println("I am " + name + " and weather is " + status);
    }

}
