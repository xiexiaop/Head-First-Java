import java.util.*;
import static java.lang.System.out;

class FullMoon {
    private static final int INT = 20;
    static int DAY_IM = 1000 * 60 * 60 * 24;//one day in millsecond

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);
        long day1 = c.getTimeInMillis();

        for (var x = 0; x < INT; x++) {
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
            out.println(String.format("full moon on %tc", c));
        }
    }
}