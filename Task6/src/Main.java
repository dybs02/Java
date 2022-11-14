import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        TreeMap<TelephoneNumber, TelephoneEntry> phoneBook = new TreeMap<TelephoneNumber, TelephoneEntry>();

        Person p1 = new Person("Michael", "Scott", "Somewhere 13, Scranton", 20, 500400800);
        Person p2 = new Person("Pam", "Beesly", "Elsewhere 64, Scranton", 20, 100100100);
        Person p3 = new Person("Ryan", "Howard", "Nowhere 2, New Jersey", 14, 400800800);
        phoneBook.put(p1.getTelephoneNumber(), p1);
        phoneBook.put(p2.getTelephoneNumber(), p2);
        phoneBook.put(p3.getTelephoneNumber(), p3);

        Company c1 = new Company("Dunder Mifflin", "Office Park 4, Scranton", 20, 555666777);
        Company c2 = new Company("Staples", "Main road 83, Scranton", 24, 999888777);
        Company c3 = new Company("Sabre", "Near the coast 7, Tallahassee", 53, 222111222);
        phoneBook.put(c1.getTelephoneNumber(), c1);
        phoneBook.put(c2.getTelephoneNumber(), c2);
        phoneBook.put(c3.getTelephoneNumber(), c3);


        for(Map.Entry<TelephoneNumber, TelephoneEntry> entry : phoneBook.entrySet()) {
            System.out.println("----------------------------------");
            System.out.println(entry.getValue().toString());
        }
    }
}