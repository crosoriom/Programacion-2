package businessLogic;

import data.CatalogueChair;
import ui.UserInterface;

public class Runner {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        CatalogueManager catalogue;
        int option = 0;

        String file = userInterface.welcome();
        catalogue = new CatalogueManager(file);

        do {
            userInterface.menu();
            option = Integer.parseInt(userInterface.readOption().trim());

            switch(option) {
            case 1:
                showCategoryMenu(catalogue);
                break;
            case 2:
                //rotación de catálogo
                break;
            case 3:
                catalogue.getChairsByCategory("catalogue");
                catalogue.getChairsByCategory("variety");
                break;
            default:
                userInterface.wrongOption();
                break;
            }
        } while(option != 4);
    }

    public static void showCategoryMenu(CatalogueManager catalogue) {
        UserInterface userInterface = new UserInterface();
        String option = "";

        do {
            userInterface.categoryMenu();
            option = userInterface.readOption().trim().toLowerCase();
            switch(option) {
                case "p":
                    catalogue.getChairsByCategory("presidential");
                    break;
                case "g":
                    catalogue.getChairsByCategory("managerial");
                    break;
                case "s":
                    catalogue.getChairsByCategory("secretarial");
                    break;
                case "t":
                    catalogue.getChairsByCategory("tandem");
                    break;
                case "r":
                    catalogue.getChairsByCategory("wheel");
                    break;
                default:
                    userInterface.wrongOption();
                    break;
            }
        } while(!option.equals("x"));
    }
}
