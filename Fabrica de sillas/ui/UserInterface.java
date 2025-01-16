package ui;

import data.CatalogueChair;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final CatalogueManager catalogueManager;
    private final Scanner scanner;

    public UserInterface() {
        catalogueManager = new CatalogueManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Inicia la interfaz de usuario, cargando las sillas y mostrando el menú principal.
     */
    public void start(String filePath) {
        // Cargar las sillas desde el archivo
        catalogueManager.loadChairs(filePath);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Fábrica de Sillas ---");
            System.out.println("1. Ver sillas por categoría");
            System.out.println("2. Ver qué sillas salen del catálogo");
            System.out.println("3. Listar todas las sillas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showCategoryMenu();
                    break;
                case "2":
                    showCatalogueStatus();
                    break;
                case "3":
                    listAllChairs();
                    break;
                case "4":
                    running = false;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Muestra el menú de selección de categoría.
     */
    private void showCategoryMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n--- Ver Sillas por Categoría ---");
            System.out.println("p. Presidencial");
            System.out.println("g. Gerencial");
            System.out.println("s. Secretarial");
            System.out.println("t. Tandem");
            System.out.println("r. Ruedas");
            System.out.println("e. Regresar al menú principal");
            System.out.print("Seleccione una categoría: ");

            String categoryChoice = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

            switch (categoryChoice) {
                case "p":
                    displayChairsByCategory("Presidential");
                    break;
                case "g":
                    displayChairsByCategory("Managerial");
                    break;
                case "s":
                    displayChairsByCategory("Secretarial");
                    break;
                case "t":
                    displayChairsByCategory("Tandem");
                    break;
                case "r":
                    displayChairsByCategory("Wheelchair");
                    break;
                case "e":
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Muestra todas las sillas en una categoría específica.
     */
    private void displayChairsByCategory(String category) {
        List<Chair<?>> chairs = catalogueManager.getChairsByCategory(category);
        if (chairs.isEmpty()) {
            System.out.println("No hay sillas en la categoría " + category + ".");
        } else {
            System.out.println("\nSillas en la categoría " + category + ":");
            for (Chair<?> chair : chairs) {
                System.out.println(chair); // Mostrará el resultado del método toString()
            }
        }
    }

    /**
     * Muestra el estado del catálogo ("Remover" o "Mantener") para cada silla.
     */
    private void showCatalogueStatus() {
        System.out.println("\n--- Estado del Catálogo ---");
        List<String> statusList = catalogueManager.getCatalogueStatus();
        if (statusList.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (String status : statusList) {
                System.out.println(status);
            }
        }
    }

    /**
     * Lista todas las sillas del catálogo.
     */
    private void listAllChairs() {
        List<Chair<?>> chairs = catalogueManager.getChairs();
        if (chairs.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("\n--- Todas las Sillas ---");
            for (Chair<?> chair : chairs) {
                System.out.println(chair); // Mostrará el resultado del método toString()
            }
        }
    }
}
