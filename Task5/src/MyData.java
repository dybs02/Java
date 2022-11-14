import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyData {

    private class MyDate {
        private int day;
        private int month;
        private int year;
        private String dayName;

        public MyDate() {}

        public boolean equals(MyDate obj) {
            if (obj == null) {
                return false;
            }

            return (
                    this.day == obj.day &&
                            this.month == obj.month &&
                            this.year == obj.year &&
                            this.dayName.equals(obj.dayName)
            );
        }

        @Override
        public String toString() {
            return "day = " + this.day +
                    ", month = " + this.month +
                    ", year = " + this.year +
                    ", weekday = " + this.dayName;
        }
    }

    private Pattern datePattern;
    private MyDate previousDate;

    public MyData() {
        this.datePattern = Pattern.compile("(\\b\\d\\d/\\d{1,2}/\\d\\d\\d\\d [a-zA-Z]+\\b)|(\\b\\d\\d\\d\\d-\\d\\d-\\d\\d [a-zA-Z]+\\b)|(\\b[a-zA-Z]+ \\d\\d[.]\\d\\d[.]\\d\\d\\d\\d\\b)");
    }

    public MyDate convertDate(String s) {
        Matcher mDate = this.datePattern.matcher(s);
        int[][] order = {{0, 1, 2, 3}, {2, 1, 0, 3}, {1, 2, 3, 0}};

        if (!mDate.matches()) {
            return null;
        }

        MyDate foundDate = new MyDate();
        for (int groupNumber = 1; groupNumber <= mDate.groupCount(); groupNumber++) {
            if (mDate.group(groupNumber) != null) {
                String[] split = mDate.group(groupNumber).split("\\.|/|[-]| ");
                foundDate.day = Integer.parseInt(split[ order[groupNumber-1][0] ]);
                foundDate.month = Integer.parseInt(split[ order[groupNumber-1][1] ]);
                foundDate.year = Integer.parseInt(split[ order[groupNumber-1][2] ]);
                foundDate.dayName = split[ order[groupNumber-1][3] ];
            }
        }

        return foundDate;
    }

    public int convertFile(String inputFile, String outputFile) {
        FileIO myFileIO = new FileIO(inputFile, outputFile);
        int lineCount = 0;

        String line = myFileIO.readLine();
        while (line != null) {
            MyDate newDate = convertDate(line);
            if (newDate != null && !newDate.equals(this.previousDate)) {
                lineCount += myFileIO.writeLine(newDate.toString());
            }

            this.previousDate = newDate;
            line = myFileIO.readLine();
        }

        myFileIO.close();
        return lineCount;
    }
}