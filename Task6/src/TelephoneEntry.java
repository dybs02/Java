

abstract class TelephoneEntry {
    public TelephoneNumber telephoneNumber;

    public abstract String description();

    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public TelephoneNumber getTelephoneNumber() {
        return this.telephoneNumber;
    }
}