package ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("\n");
        System.out.println("---Sistema de ordenamiento de estudiantes---");
        System.out.println("1. Ordenar por ID.");
        System.out.println("2. Ordenar por nombres.");
        System.out.println("3. Ordenar por apellidos.");
        System.out.println("4. Ordenar por fecha de nacimiento.");
        System.out.println("5. Ordenar por promedio académico (PAPA).");
        System.out.println("6. Ordenar por signo zodiacal");
    }

    public String readOption() {
        System.out.println("Por favor ingrese una opción.");
        return scan.next();
    }

    public void wrongOption() {
        System.out.println("Por favor ingrese una opción válida.");
    }
}

