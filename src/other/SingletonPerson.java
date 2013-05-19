package other;
public class SingletonPerson {

    private static SingletonPerson singletonPerson = new SingletonPerson();

    private String firstName;
    private String lastName;
    private int age;

    private SingletonPerson() {
    }

    public static SingletonPerson getReference() {
        return singletonPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age;
    }

}
