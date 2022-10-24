import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            // TODO fix path

            MyDate.convertFile("/home/mateusz/Desktop/Java/Task5/src/InputData1k.txt", "/home/mateusz/Desktop/Java/Task5/src/out.txt");

        } catch (FileNotFoundException ignored) {}

//        MyDate d = new MyDateSlash("07/06/1850 Friday");
//        System.out.println(d);

    }
}