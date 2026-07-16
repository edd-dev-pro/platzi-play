package platzi.play.util;

import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int getNumber(String message) {
        System.out.println(message + ": ");

        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    public static double getDecimal(String message) {
        System.out.println(message + ": ");

        double number = SCANNER.nextDouble();
        SCANNER.nextLine();
        return number;
    }
}
