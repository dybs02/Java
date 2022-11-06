import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path currentPath = Paths.get("");
        String inputFile = currentPath.toAbsolutePath().toString() + "/InputData1k.txt";
        String outputFile = currentPath.toAbsolutePath().toString() + "/out.txt";

        System.out.println(
            (new MyData()).convertFile(inputFile, outputFile)
        );

    }
}