import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private static final String[] DAYS_OF_WEEK = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    public Date() {
        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date: " + month + "/" + day + "/" + year);
        }
    }

    public Date(Date other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    public boolean isValidDate() {
        return isValidDate(this.day, this.month, this.year);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;
        if (year < 1) return false;

        int daysInMonth;

        if (month == 2) {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            daysInMonth = isLeap ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }

        return day <= daysInMonth;
    }

    public boolean updateDate(int d, int m, int y) {
        if (isValidDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
            return true;
        }
        return false;
    }

    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return DAYS_OF_WEEK[dayOfWeek];
    }

    public long calculateDifference(Date otherDate) {
        Calendar thisCalendar = new GregorianCalendar(this.year, this.month - 1, this.day);
        Calendar otherCalendar = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);

        long diffMillis = thisCalendar.getTimeInMillis() - otherCalendar.getTimeInMillis();
        return diffMillis / (24 * 60 * 60 * 1000);
    }

    public String printDate() {
        return MONTH_NAMES[month - 1] + " " + day + ", " + year;
    }

    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }

        if (this.month != other.month) {
            return this.month - other.month;
        }

        return this.day - other.day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
}