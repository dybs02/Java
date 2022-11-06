import java.io.*;

public class FileIO {

    private File inputFile;
    private File outputFile;
    private BufferedReader reader;
    private BufferedWriter writer;

    public FileIO(String inputFileName, String outputFileName) {
        this.inputFile = new File(inputFileName);
        this.outputFile = new File(outputFileName);

        try {
            this.reader = new BufferedReader(new FileReader(this.inputFile));
            this.writer = new BufferedWriter(new FileWriter(this.outputFile));
        } catch (java.io.IOException e) {
            System.out.println("Wrong input/output file");
            System.exit(-1);
        }
    }

    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (java.io.IOException e) {
            System.out.println("Error while reading from file");
            System.exit(-1);
        }
        return "";
    }

    public int writeLine(String text) {
        try {
            this.writer.write(text + "\n");
            this.writer.flush();
            return 1;
        } catch (java.io.IOException e) {
            System.out.println("Error while writing to file");
            System.exit(-1);
        }
        return 0;
    }

    public void close() {
        try {
            this.reader.close();
            this.writer.close();
        } catch (java.io.IOException e) {
            System.out.println("Error while closing files");
            System.exit(-1);
        }
    }
}
