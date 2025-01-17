package businessLogic;

import data.Chair;
import java.util.List;
import ui.UserInterface;

public class Runner {
    public static void main(String[] args) {
       
        CatalogueManager catalogueManager = new CatalogueManager();
        UserInterface userInterface = new UserInterface();

        

        userInterface.welcome();

        int option = 0;

        do {
            userInterface.menu();

            try {
                option = Integer.parseInt(userInterface.readOption().trim());
            } catch (NumberFormatException e){
                userInterface.wrongOption();
                continue;
            }

            switch(option) {
            case 1:
                //showCategoryMenu();
                showCategoryMenu(catalogueManager, userInterface);
                break;
            case 2:
                // Rotación del catálogo (remover sillas)
                rotateCatalogue(catalogueManager, userInterface);
                break;
            case 3:
                //listar sillas
                listAllChairs(catalogueManager);
                //userInterface.printChairs(catalogueManager.getAllChairs());
                break;
            case 4: 
                userInterface.exitMessage();
                break;
            default:
                userInterface.wrongOption();
                break;
            }
        } while(option != 4);
    }


    

    //public static void showCategoryMenu() {
    public static void showCategoryMenu(CatalogueManager catalogueManager, UserInterface userInterface){
        //UserInterface userInterface = new UserInterface();
        String option = "";

        do {
            userInterface.categoryMenu();
            System.out.println(option);
            option = userInterface.readOption().trim().toLowerCase();

            switch (option) {
                case "p":
                    listChairsByCategory(catalogueManager, "presidencial");
                    //userInterface.printChairs(catalogueManager.getChairsByCategory(PresidentialChair.class));
                    break;
                case "g":
                    listChairsByCategory(catalogueManager, "gerencial");
                    break;
                case "s":
                    listChairsByCategory(catalogueManager, "secretarial");
                    break;
                case "t":
                    listChairsByCategory(catalogueManager, "tandem");
                    break;
                case "r":
                    listChairsByCategory(catalogueManager, "ruedas");
                    break;
                case "x":
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    userInterface.wrongOption();
            }
        } while (!option.equals("x"));
    }

    public static void listChairsByCategory(CatalogueManager catalogueManager, String category) {
        List<Chair> chairs = catalogueManager.getChairsByCategory(category);
        if (chairs.isEmpty()) {
            System.out.println("No hay sillas disponibles en la categoría: " + category);
        } else {
            System.out.println("Sillas en la categoría " + category + ":");
            for (Chair chair : chairs) {
                System.out.println(chair);
            }
        }
    }

    public static void listAllChairs(CatalogueManager catalogueManager) {
        List<Chair> allChairs = catalogueManager.getAllChairs();
        if (allChairs.isEmpty()) {
            System.out.println("No hay sillas disponibles en el catálogo.");
        } else {
            System.out.println("Lista de todas las sillas en el catálogo:");
            for (Chair chair : allChairs) {
                System.out.println(chair);
            }
        }
    }

    public static void rotateCatalogue(CatalogueManager catalogueManager, UserInterface userInterface) {
        // Obtiene las referencias de las sillas que deben ser removidas
        List<String> chairsToRemove = catalogueManager.getChairsToRemove();
        
        // Verifica si hay sillas para remover
        if (chairsToRemove.isEmpty()) {
            System.out.println("No hay sillas que necesiten ser removidas del catálogo.");
        } else {
            System.out.println("Sillas que serán removidas del catálogo:");
            for (String reference : chairsToRemove) {
                System.out.println("- Referencia: " + reference);
            }
        }
    }
}
