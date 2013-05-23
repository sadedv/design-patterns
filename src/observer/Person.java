package observer;

public class Person implements Observer<String> {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("I am " + name + " and weather is " + message);
    }

}
