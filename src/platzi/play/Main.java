package platzi.play;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        System.out.println("Platzi Play");

        Scanner scanner = new Scanner(System.in); // with this parameter we will be reviewing what the user enters via the console
        System.out.println("¿Cuál es tu nombre?");
        String name = scanner.nextLine(); // this is a variable, we capture the next line that the user types into the console

        System.out.println("Hola " + name + ", esto es Platzi Play 🚀");

        System.out.println(name + "¿Cuanto años tienes?");
        int age = scanner.nextInt();

        System.out.println(name + ", puedes ver contenido +" + age);
    }
}
