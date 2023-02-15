package csc330.ch5;

import java.util.Scanner;

public class KeyboardInput {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number:");
        double value = keyboard.nextDouble();
        System.out.printf("You have entered: %f\n", value);
    }
}
