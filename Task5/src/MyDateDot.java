import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyDateDot extends MyDate{

    public MyDateDot(String s) {
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+ \\d\\d[.]\\d\\d[.]\\d\\d\\d\\d\\b");
        Matcher mDate = pattern.matcher(s);

        if (mDate.matches()) {
            String[] split = mDate.group(0).split("[.]| ");

            this.day = Integer.parseInt(split[1]);
            this.month = Integer.parseInt(split[2]);
            this.year = Integer.parseInt(split[3]);
            this.dayName = split[0];
        }
    }

}
