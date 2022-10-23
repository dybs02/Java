import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OldMyData {

    private int day;
    private int month;
    private int year;
    private String dayName;


    public OldMyData() {

    }

    public OldMyData(int day, int month, int year, String dayName) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayName = dayName;
    }

    public static void convertDate(String inputFile, String outputFile) {
//        BufferedReader br = new BufferedReader(new FileReader(inputFile));

//        String line = br.readLine();
//
//        while (line != null) {
//            sb.append(line);
//            sb.append(System.lineSeparator());
//            line = br.readLine();
//        }


    }

    private OldMyData convertFromSlash(String date) {
        Pattern slashDatePattern = Pattern.compile("\\b\\d\\d/\\d{1,2}/\\d\\d\\d\\d [a-zA-Z]+\\b");
        Matcher mSlashDate = slashDatePattern.matcher(date);

        if (mSlashDate.matches()) {
            String[] split = mSlashDate.group(0).split("/| ");

            return new OldMyData(
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    split[3]
            );
        }
        return null;
    }

    private OldMyData convertFromDash(String date) {
        Pattern dotDatePattern = Pattern.compile("\\b\\d\\d\\d\\d-\\d\\d-\\d\\d [a-zA-Z]+\\b");
        Matcher mDotDate = dotDatePattern.matcher(date);

        if (mDotDate.matches()) {
            String[] split = mDotDate.group(0).split("-| ");

            return new OldMyData(
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[0]),
                    split[3]
            );
        }
        return null;
    }

    private OldMyData convertFromDot(String date) {
        Pattern dashDatePattern = Pattern.compile("\\b[a-zA-Z]+ \\d\\d[.]\\d\\d[.]\\d\\d\\d\\d\\b");
        Matcher mDashDate = dashDatePattern.matcher(date);

        if (mDashDate.matches()) {
            String[] split = mDashDate.group(0).split("[.]| ");

            return new OldMyData(
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]),
                    split[0]
            );
        }
        return null;
    }

    @Override
    public String toString() {
        return "day =" + this.day + ", month =" + this.month + ", year =" + this.year + ", weekday =" + this.dayName;
    }
}


























