import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {

        if (args.length == 0 || toInt(args[0]) == null) {
            return;
        }

        ArrayList<MyVector> vectors = new ArrayList<>();
        int count = 0;
        int numOfVectors = toInt(args[0]);
        scanner = new Scanner(System.in);

        while (scanner.hasNextLine() && count < numOfVectors) {
            ArrayList<Integer> inputValues = new ArrayList<>();
            System.out.print("Enter vector " + (count+1) + ": ");
            String[] elements = scanner.nextLine().split(",");

            for (String element : elements) {
                Integer num = toInt(element.strip());
                if (num != null) {
                    inputValues.add(num);
                }
            }

            if (inputValues.size() > 0) {
                vectors.add(new MyVector(inputValues));
                count++;
            }
        }

        for (MyVector v : vectors) {
            System.out.println(v);
        }
    }

    public static Integer toInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e) {
            return null;
        }
        return num;
    }
}