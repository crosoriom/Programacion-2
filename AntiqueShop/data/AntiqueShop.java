package data;

import businessLogic.InventoryManager;
import java.util.ArrayList;

public class AntiqueShop {
    private InventoryManager stock; 

    public AntiqueShop(InventoryManager inventory) {
        this.stock = inventory;
    }

    public void showItems(String category) {
        for(Item item : stock.getItems())
            if(item.toString().contains(category))
                System.out.println(item);
    }
}
