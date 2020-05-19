public class Employee implements Identified, Person {
    @Override
    public String getName() {
        return null;
    }

    public int getId() {
        return Identified.super.getId();
    }

    public int getSecretId() {
        return Person.super.getId();
    }
}
