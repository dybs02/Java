import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {

        if (args.length == 0 || toInt(args[0]) == null) {
            return;
        }

        scanner = new Scanner(System.in);
        MyVector sumOfVectors = new MyVector();
        boolean successful = false;

        while (!successful) {
            ArrayList<MyVector> inputVectors = getUserVectorsInput(toInt(args[0]));
            sumOfVectors = new MyVector(inputVectors.get(0).getLength());
            successful = true;

            for (MyVector v : inputVectors) {
                try {
                    sumOfVectors = sumOfVectors.add(v);
                } catch (MyVector.DifferentVectorsLengthsException e) {
                    System.out.println(e);
                    successful = false;
                    break;
                }
            }
        }

        FileOutput fileOut = new FileOutput("./sumOfVectors.txt");
        fileOut.writeLine(sumOfVectors.toString());
        fileOut.close();
    }

    public static ArrayList<MyVector> getUserVectorsInput(int numberOfVectors) {
        ArrayList<MyVector> vectors = new ArrayList<>();

        while (vectors.size() < numberOfVectors) {

            System.out.print("Enter vector " + (vectors.size()+1) + ": ");

            ArrayList<Integer> vectorElements = extractVectorElements(scanner.nextLine());
            if (vectorElements.size() > 0) {
                vectors.add(new MyVector(vectorElements));
            }
        }

        return vectors;
    }

    public static ArrayList<Integer> extractVectorElements(String line) {
        ArrayList<Integer> vectorElements = new ArrayList<>();

        for (String element : line.split(",")) {
            Integer num = toInt(element);

            if (num != null) {
                vectorElements.add(num);
            }
        }

        return vectorElements;
    }

    public static Integer toInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s.strip());
        }catch (NumberFormatException e) {
            return null;
        }
        return num;
    }
}