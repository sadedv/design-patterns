package other;

public final class SingletonPersonClient {

    public static void main(String[] args) {

        SingletonPerson person = SingletonPerson.getReference();

        person.setFirstName("Tomas");
        person.setLastName("Jakubco");
        person.setAge(20);

        System.out.println(person);
    }

}
