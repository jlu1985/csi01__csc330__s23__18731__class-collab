package csi.csc330.jia_lu;

import java.util.Scanner;

public class SaleCommission {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter sale total:");
        double salesTotal = scanner.nextDouble();
        System.out.println("enter sale name:");
        String name = scanner.next();

        System.out.println("enter sale's adv pay:");
        double adv = scanner.nextDouble();


        System.out.printf("%s gets diff %f", name, calculateCommission(salesTotal) - adv);

    }

    private static double calculateCommission(double salesTotal) {
        if (salesTotal < 10000) {
            return salesTotal * 0.05;
        } else
        if (salesTotal <= 14999) {
            return salesTotal * 0.1;
        }

        if (salesTotal <= 17999) {
            return salesTotal * 0.12;
        }
        if (salesTotal <= 21999) {
            return salesTotal * 0.15;
        }
        return salesTotal * 0.16;

    }
}
