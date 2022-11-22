

abstract class TelephoneEntry {
    private TelephoneNumber telephoneNumber;

    public TelephoneEntry(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public abstract String description();

    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public TelephoneNumber getTelephoneNumber() {
        return this.telephoneNumber;
    }
}