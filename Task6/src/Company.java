

public class Company extends TelephoneEntry{
    private String name;
    private String address;

    public Company(String name, String address, int countryCode, int localNumber) {
        this.name = name;
        this.address = address;
        this.setTelephoneNumber(new TelephoneNumber(countryCode, localNumber));
    }

    @Override
    public String description() {
        return String.format(
                "Company name: %s\nAddress: %s\nPhone number: %s",
                this.name,
                this.address,
                this.telephoneNumber
        );
    }

    @Override
    public String toString() {
        return this.description();
    }
}