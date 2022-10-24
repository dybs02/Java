import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDate {

    protected int day;
    protected int month;
    protected int year;
    protected String dayName;

    public MyDate() {

    }

    public static boolean isCorrectFormat(String s) {
        // TODO create better regex (weekdays, valid days and months)
        Pattern datePattern = Pattern.compile("\\b\\d\\d/\\d{1,2}/\\d\\d\\d\\d [a-zA-Z]+\\b|\\b\\d\\d\\d\\d-\\d\\d-\\d\\d [a-zA-Z]+\\b|\\b[a-zA-Z]+ \\d\\d[.]\\d\\d[.]\\d\\d\\d\\d\\b");
        Matcher mDate = datePattern.matcher(s);

        return mDate.matches();
    }

    public static int convertFile(String inputFile, String outputFile) throws FileNotFoundException {
        int writtenLines = 0;
        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        try {
            BufferedWriter writer = Files.newBufferedWriter(
                    FileSystems.getDefault().getPath(outputFile),
                    StandardCharsets.US_ASCII);
            String line = br.readLine();

            while (line != null) {
                String new_line = (new MyDateDash(line)).toString() + (new MyDateSlash(line)).toString() + (new MyDateDot(line)).toString();
                if (!new_line.equals("")) {
                    writer.write(new_line);
                    writer.newLine();
                    writtenLines++;
                }

                line = br.readLine();
            }

            writer.close();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

        return writtenLines;
    }

    @Override
    public String toString() {
        if (this.day == 0) {
            return "";
        }

        return "day = " + this.day +
                ", month = " + this.month +
                ", year = " + this.year +
                ", weekday = " + this.dayName;
    }
}
























