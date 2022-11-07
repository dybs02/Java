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
            System.err.println("Wrong input/output file");
            e.printStackTrace();
        }
    }

    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (java.io.IOException e) {
            System.err.println("Error while reading from file");
            e.printStackTrace();
        }
        return "";
    }

    public int writeLine(String text) {
        try {
            this.writer.write(text + "\n");
            this.writer.flush();
            return 1;
        } catch (java.io.IOException e) {
            System.err.println("Error while writing to file");
            e.printStackTrace();
        }
        return 0;
    }

    public void close() {
        try {
            this.reader.close();
            this.writer.close();
        } catch (java.io.IOException e) {
            System.err.println("Error while closing files");
            e.printStackTrace();
        }
    }
}
