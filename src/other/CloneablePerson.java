package other;
public class CloneablePerson implements Cloneable {

    private String firstName;
    private String lastName;
    private int age;

    public CloneablePerson(String firstName, String lastName, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneablePerson p1 = new CloneablePerson("Tomas", "Jakubco", 20);

        CloneablePerson p2 = (CloneablePerson) p1.clone();

        System.out.println(p1);
        System.out.println(p2);

    }

}
