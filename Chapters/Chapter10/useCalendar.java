import java.util.Calendar;

class useCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2019, 1, 16, 8, 23, 56);

        System.out.println("Initial time " + c.getTime());// Initial time Sat Feb 16 08:23:56 CST 2019

        long day1 = c.getTimeInMillis();
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("New hour " + c.get(c.HOUR_OF_DAY));// New hour 9

        c.add(c.DATE, 10);
        System.out.println("Add 10 days " + c.getTime());// Add 10 days Tue Feb 26 09:23:56 CST 2019

        c.roll(c.DATE, 2);
        System.out.println("roll 2 days " + c.getTime());//roll 2 days Thu Feb 28 09:23:56 CST 2019

        c.set(c.DATE, 16);
        System.out.println("set to 16 " + c.getTime());//
    }
}