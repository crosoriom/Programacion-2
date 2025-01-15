package ui;

import data.CatalogueChair;
import data.ManagerialChair;
import data.PresidentialChair;
import data.SecretarialChair;
import data.TandemChair;
import data.Wheelchair;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final CatalogueManager catalogueManager;
    private final Scanner scanner;

    public UserInterface() {
        catalogueManager = new CatalogueManager();
        scanner = new Scanner(System.in);
        catalogueManager.loadChairs(); // Carga las sillas desde el archivo al iniciar
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("Fabrica de Sillas----");
            System.out.println("Para ver sillas por categoría, digite 'c'");
            System.out.println("Para ver qué sillas salen del catálogo, digite 's'");
            System.out.println("Para terminar, digite 't'");
            System.out.print("¿Qué opción desea? ");
            String option = scanner.nextLine();

            switch (option) {
                case "c":
                    displayCategoryMenu();
                    break;
                case "s":
                    displayCatalogueStatus();
                    break;
                case "t":
                    System.out.println("Terminando el programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    private void displayCategoryMenu() {
        while (true) {
            System.out.println("Para ver sillas presidenciales, digite 'p'");
            System.out.println("Para ver sillas gerenciales, digite 'g'");
            System.out.println("Para ver sillas secretariales, digite 's'");
            System.out.println("Para ver sillas tandem, digite 't'");
            System.out.println("Para ver sillas de ruedas, digite 'r'");
            System.out.println("Para regresar al menú principal, digite 'r'");
            System.out.print("¿Qué opción desea? ");
            String option = scanner.nextLine();

            switch (option) {
                case "p":
                    displayPresidentialChairs();
                    break;
                case "g":
                    displayManagerialChairs();
                    break;
                case "s":
                    displaySecretarialChairs();
                    break;
                case "t":
                    displayTandemChairs();
                    break;
                case "r":
                    return; // Regresa al menú principal
                case "r":
                    displayWheelchairs();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }

    private void displayPresidentialChairs() {
        System.out.println("Sillas Presidenciales:");
        for (CatalogueChair chair : catalogueManager.getChairs()) {
            if (chair instanceof PresidentialChair) {
                System.out.println("Referencia: " + chair.getReference() +
                        ", Precio: " + chair.getPrice() +
                        ", Calificación: " + chair.getQualification());
            }
        }
    }

    private void displayManagerialChairs() {
        System.out.println("Sillas Gerenciales:");
        for (CatalogueChair chair : catalogueManager.getChairs()) {
            if (chair instanceof ManagerialChair) {
                System.out.println("Referencia: " + chair.getReference() +
                        ", Precio: " + chair.getPrice() +
                        ", Calificación: " + chair.getQualification());
            }
        }
    }

    private void displaySecretarialChairs() {
        System.out.println("Sillas Secretariales:");
        for (CatalogueChair chair : catalogueManager.getChairs()) {
            if (chair instanceof SecretarialChair) {
                System.out.println("Referencia: " + chair.getReference() +
                        ", Precio: " + chair.getPrice() +
                        ", Calificación: " + chair.getQualification());
            }
        }
    }

    private void displayTandemChairs() {
        System.out.println("Sillas Tandem:");
        for (CatalogueChair chair : catalogueManager.getChairs()) {
            if (chair instanceof TandemChair) {
                System.out.println("Referencia: " + chair.getReference() +
                        ", Precio: " + chair.getPrice() +
                        ", Calificación: " + chair.getQualification());
            }
        }
    }

    private void displayWheelchairs() {
        System.out.println("Sillas de Ruedas:");
        for (CatalogueChair chair : catalogueManager.getChairs()) {
            if (chair instanceof Wheelchair) {
                System.out.println("Referencia: " + chair.getReference() +
                        ", Precio: " + chair.getPrice() +
                        ", Calificación: " + chair.getQualification());
            }
        }
    }

    private void displayCatalogueStatus() {
        System.out.println("Sillas que deben salir del catálogo:");

        for (CatalogueChair chair : catalogueManager.getChairs()) {
            String status = "Mantener";
            if (chair instanceof PresidentialChair) {
                PresidentialChair presidentialChair = (PresidentialChair) chair;
                if ((presidentialChair.isImported() && presidentialChair.getQualification() < 3.5) ||
                        presidentialChair.getPrice() > 400000) {
                    status = "Remover";
                }
            } else if (chair instanceof ManagerialChair) {
                ManagerialChair managerialChair = (ManagerialChair) chair;
                if (managerialChair.getQualification() < 4 || managerialChair.getPrice() > 300000) {
                    status = "Remover";
                }
            } else if (chair instanceof SecretarialChair) {
                SecretarialChair secretarialChair = (SecretarialChair) chair;
                if (secretarialChair.getQualification() < 3 || secretarialChair.getPrice() > 200000) {
                    status = "Remover";
                }
            }

            System.out.println(chair.getClass().getSimpleName() + ", " + status);
        }
    }
}
