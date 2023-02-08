package csi.csc330.jia_lu;

import java.util.Random;
import java.util.Scanner;

//ch5 program 18
public class ESP {

    public static void main(String[] args) {
        int correctCount = 0;
        Random random = new Random();
        var scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            var pickedColor = Math.abs((random.nextInt() / 1000) % 5);
            int guessedNumber = guessNext(scanner);
            if (pickedColor == guessedNumber) {
                correctCount++;
            }
            System.out.println(pickedColor);
        }
        System.out.println("total right guess " + correctCount);
        scanner.close();
    }

    private static int guessNext(Scanner scanner) {
        System.out.println("Enter a guess number");
        return scanner.nextInt();
    }
}
