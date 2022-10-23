import java.io.*;
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

    public static void convertFile(String inputFile, String outputFile) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
//        PrintWriter writer = new PrintWriter("the-file-name.txt");
        FileWriter out;
        try {
            out = new FileWriter(outputFile);
        }catch (java.io.IOException e){
            throw new RuntimeException(e);
        }

        try {
            String line = br.readLine();

            while (line != null) {
                System.out.println(isCorrectFormat(line) + "\t" + line);
                System.out.println(new MyDateSlash(line));


                line = br.readLine();
            }
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
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
























