package platzi.play.util;

import platzi.play.contenido.Gender;

import java.awt.*;
import java.util.Scanner;

public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int getNumber(String message) {
        System.out.println(message + ": ");

        while (!SCANNER.hasNextInt()) {
            System.out.println("Dato no aceptado. " + message + ": ");
            SCANNER.next();
        }

        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    public static double getDecimal(String message) {
        System.out.println(message + ": ");

        while (!SCANNER.hasNextDouble()) {
            System.out.println("Dato no aceptado. " + message + ": ");
            SCANNER.next();
        }

        double number = SCANNER.nextDouble();
        SCANNER.nextLine();
        return number;
    }

    public static Gender getGender(String message) {
        while (true) {
            System.out.println(message + "... Opccines:");
            for (Gender gender : Gender.values()) {
                System.out.println("-" + gender.name());
            }

            System.out.println("¿Cuál quieres?");
            String input = SCANNER.nextLine();

            try {
                return Gender.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Género no aceptado. ");
            }
        }
    }
}
