package businessLogic;

import ui.UserInterface;

public class Runner {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        //CatalogueManager catalogue = new CatalogueManager();
        int option = 0;

        do {
            userInterface.menu();
            option = Integer.parseInt(userInterface.readOption().trim());

            switch(option) {
            case 1:
                showCategoryMenu();
                break;
            case 2:
                //rotación de catálogo
                break;
            case 3:
                //listar sillas
                break;
            default:
                userInterface.wrongOption();
                break;
            }
        } while(option != 4);
    }

    public static void showCategoryMenu() {
        UserInterface userInterface = new UserInterface();
        String option = "";

        do {
            userInterface.categoryMenu();
            System.out.println(option);
            option = userInterface.readOption().trim().toLowerCase();
            switch(option) {
                case "p":
                    //mostrar presidenciales
                    break;
                case "g":
                    break;
                case "s":
                    break;
                case "t":
                    break;
                case "r":
                    break;
                default:
                    userInterface.wrongOption();
            }
        } while(!option.equals("x"));
    }
}
