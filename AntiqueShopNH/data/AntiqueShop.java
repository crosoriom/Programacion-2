package data;

import businessLogic.InventoryManager;
import java.util.ArrayList;

public class AntiqueShop {
    private InventoryManager stock; 

    public AntiqueShop(InventoryManager inventory) {
        this.stock = inventory;
    }

    public void showAllVases() {
        ArrayList<Vase> vases = this.stock.getVases();
        for(Vase vase : vases)
            System.out.println(vase);
    }

    public void showAllStatues() {
        ArrayList<Statue> statues = this.stock.getStatues();
        for(Statue statue : statues)
            System.out.println(statue);
    }

    public void showAllPaintings() {
        ArrayList<Painting> paintings= this.stock.getPaintings();
        for(Painting painting: paintings)
            System.out.println(painting);
    }
}
