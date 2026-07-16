package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    public static int getNumber(String message) {
        System.out.println(message + ": ");

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static double getDecimal(String message) {
        System.out.println(message + ": ");

        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }
}
