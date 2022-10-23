import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDateSlash extends MyDate{

    public MyDateSlash(String s) {
        Pattern pattern = Pattern.compile("\\b\\d\\d/\\d{1,2}/\\d\\d\\d\\d [a-zA-Z]+\\b");
        Matcher mDate = pattern.matcher(s);

        if (mDate.matches()) {
            String[] split = mDate.group(0).split("/| ");

            this.day = Integer.parseInt(split[0]);
            this.month = Integer.parseInt(split[1]);
            this.year = Integer.parseInt(split[2]);
            this.dayName = split[3];
        }
    }

}
