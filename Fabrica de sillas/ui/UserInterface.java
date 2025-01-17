package ui;

import java.util.Scanner;

public class UserInterface {
    private Scanner scan = new Scanner(System.in);

    public String welcome() {
        System.out.println("");
    }

    public void menu() {
        System.out.println("\n");
        System.out.println("---Fábrica de Sillas---");
        System.out.println("1. Ver sillas por categoría");
        System.out.println("2. Ver la rotación del catálogo");
        System.out.println("3. Listar sillas");
        System.out.println("4. Salir");
        System.out.println("\n");
    }

    public String readOption() {
        System.out.println("Por favor ingrese una opción.");
        return scan.next();
    }

    public void wrongOption() {
        System.out.println("Por favor ingrese una opción válida.");
    }

    public void categoryMenu() {
        System.out.println("\n");
        System.out.println("---Categorías---");
        System.out.println("P. Presidencial");
        System.out.println("G. Gerencial");
        System.out.println("S. Secretarial");
        System.out.println("T. Tandem");
        System.out.println("R. Sillas de ruedas");
        System.out.println("\n");
        System.out.println("0. Regresar al menú principal");
        System.out.println("\n");
    }
}
