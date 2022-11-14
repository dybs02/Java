

public class TelephoneNumber implements Comparable<TelephoneNumber> {
    private int countryCode;
    private int localNumber;

    public TelephoneNumber(int countryCode, int localNumber) {
        this.countryCode = countryCode;
        this.localNumber = localNumber;
    }

    @Override
    public String toString() {
        return String.format("+%d %d", this.countryCode, this.localNumber);
    }

    @Override
    public int compareTo(TelephoneNumber o) {
        if (this.countryCode != o.countryCode) {
            return this.countryCode - o.countryCode;
        }
        return this.localNumber - o.localNumber;
    }
}