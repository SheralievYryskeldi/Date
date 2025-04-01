import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Date Class Demonstration");
        System.out.println("=======================");

        System.out.println("\n1. Creating Date objects:");

        Date today = new Date();
        System.out.println("Today's date: " + today.printDate());

        try {
            Date validDate = new Date(15, 6, 2023);
            System.out.println("Valid date created: " + validDate.printDate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Date invalidDate = new Date(30, 2, 2023);
            System.out.println("This shouldn't print: " + invalidDate);
        } catch (IllegalArgumentException e) {
            System.out.println("Error (expected): " + e.getMessage());
        }

        try {
            Date leapYearDate = new Date(29, 2, 2024);
            System.out.println("Valid leap year date: " + leapYearDate.printDate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n2. Updating Date objects:");
        Date dateToUpdate = new Date(1, 1, 2023);
        System.out.println("Original date: " + dateToUpdate.printDate());

        boolean updateResult = dateToUpdate.updateDate(25, 12, 2023);
        System.out.println("Update result: " + updateResult);
        System.out.println("Updated date: " + dateToUpdate.printDate());

        updateResult = dateToUpdate.updateDate(31, 2, 2023);
        System.out.println("Invalid update result: " + updateResult);
        System.out.println("Date after invalid update: " + dateToUpdate.printDate());

        System.out.println("\n3. Getting day of the week:");
        Date newYears2023 = new Date(1, 1, 2023);
        System.out.println(newYears2023.printDate() + " was a " + newYears2023.getDayOfWeek());

        Date independenceDay = new Date(4, 7, 2023);
        System.out.println(independenceDay.printDate() + " was a " + independenceDay.getDayOfWeek());

        System.out.println("\n4. Calculating difference between dates:");
        Date date1 = new Date(1, 1, 2023);
        Date date2 = new Date(1, 3, 2023);
        long diff = date2.calculateDifference(date1);
        System.out.println("Days between " + date1.printDate() + " and " + date2.printDate() + ": " + diff);

        System.out.println("\n5. Sorting dates:");
        ArrayList<Date> dateList = new ArrayList<>();
        dateList.add(new Date(15, 3, 2023));
        dateList.add(new Date(5, 1, 2024));
        dateList.add(new Date(20, 12, 2022));
        dateList.add(new Date(10, 7, 2023));

        System.out.println("Unsorted dates:");
        for (Date date : dateList) {
            System.out.println("  " + date.printDate());
        }

        Collections.sort(dateList);

        System.out.println("\nSorted dates:");
        for (Date date : dateList) {
            System.out.println("  " + date.printDate());
        }

        System.out.println("\n6. Create your own date:");
        try {
            System.out.print("Enter day: ");
            int userDay = scanner.nextInt();

            System.out.print("Enter month: ");
            int userMonth = scanner.nextInt();

            System.out.print("Enter year: ");
            int userYear = scanner.nextInt();

            Date userDate = new Date(userDay, userMonth, userYear);
            System.out.println("Your date: " + userDate.printDate());
            System.out.println("Day of week: " + userDate.getDayOfWeek());
            System.out.println("Days from today: " + userDate.calculateDifference(today));
        } catch (Exception e) {
            System.out.println("Error with input: " + e.getMessage());
        }

        scanner.close();
    }
}