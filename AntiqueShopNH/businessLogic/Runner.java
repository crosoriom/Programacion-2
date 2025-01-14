package businessLogic;

import data.AntiqueShop;
import ui.UserInterface;

public class Runner {
    public static void main(String[] args) {
        InventoryManager stock = new InventoryManager("items.txt");
        stock.readingRecords();
        AntiqueShop store = new AntiqueShop(stock);
        UserInterface userInterface = new UserInterface();
        int option = 0;
        userInterface.welcome();

        do {
            userInterface.showMenu();
            option = userInterface.readOption();

            switch(option) {
            case 1:
                store.showAllStatues();
                break;
            case 2:
                store.showAllPaintings();
                break;
            case 3:
                store.showAllVases();
                break;
            case 4:
                userInterface.bye();
                break;
            default:
                userInterface.wrongOption();
                break;
            }
        } while(option != 4);
    }
}
