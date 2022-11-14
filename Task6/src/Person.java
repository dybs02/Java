

public class Person extends TelephoneEntry{
    private String name;
    private String lastName;
    private String address;

    public Person(String name, String lastName, String address, int countryCode, int localNumber) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.setTelephoneNumber(new TelephoneNumber(countryCode, localNumber));
    }

    @Override
    public String description() {
        return String.format(
                "Name: %s %s\nAddress: %s\nPhone number: %s",
                this.name,
                this.lastName,
                this.address,
                this.telephoneNumber
        );
    }

    @Override
    public String toString() {
        return this.description();
    }
}