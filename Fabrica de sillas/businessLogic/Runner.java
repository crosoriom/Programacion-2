package businessLogic;

import ui.userInterface;

public class Runner {
    public void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        CatalogueManager catalogue = new CatalogueManager();
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

    public void showCategoryMenu() {
        UserInterface userInterface = new UserInterface();
        String option;

        do {
            userInterface.categoryMenu();
            option = userInterface.readOption().trim().lower();
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
        } while(option != "0");
    }
}
