package ui;

import java.util.Scanner;
import data.AntiqueShop;

public class UserInterface {
    private Scanner scan = new Scanner(System.in);

    public void welcome() {
        System.out.println("Bienvenidos a mi tienda.");
    }

    public void showMenu() {
        System.out.println("Por favor seleccione una opción:");
        System.out.println("1. Ver Estatuas");
        System.out.println("2. Ver Pinturas");
        System.out.println("3. Ver Jarrones");
        System.out.println("4. Salir");
    }

    public int readOption() {
        return Integer.parseInt(scan.next().trim());
    }

    public void wrongOption() {
        System.out.println("Por favor ingrese una opción válida.");
    }

    public void bye() {
        System.out.println("Por favor vuelva pronto.");
    }
}
