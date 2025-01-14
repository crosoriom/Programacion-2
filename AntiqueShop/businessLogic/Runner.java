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
                store.showItems("Statue");
                break;
            case 2:
                store.showItems("Painting");
                break;
            case 3:
                store.showItems("Vase");
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
