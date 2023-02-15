package csc330.ch6;

import java.util.Scanner;

public class MonthYear {
    private final int month;
    private final int year;

    public MonthYear(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter a month");
            int month = scanner.nextInt();
            System.out.println("enter a year");
            int year = scanner.nextInt();

            int days = new MonthYear(month, year).getDays();
            System.out.printf("month %d days %d", month, days);
        }
    }

    private boolean isLeapYear() {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    public int getDays() {

        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear() ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        };
    }
}
