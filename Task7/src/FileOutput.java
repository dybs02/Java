import java.io.*;

public class FileOutput {

    private File outputFile;
    private BufferedWriter writer;


    public FileOutput(String outputFileName) {
        this.outputFile = new File(outputFileName);

        try {
            this.writer = new BufferedWriter(new FileWriter(this.outputFile));
        } catch (java.io.IOException e) {
            System.err.println("Wrong output file");
            e.printStackTrace();
        }
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
            this.writer.close();
        } catch (java.io.IOException e) {
            System.err.println("Error while closing files");
            e.printStackTrace();
        }
    }
}
