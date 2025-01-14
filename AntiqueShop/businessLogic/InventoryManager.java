package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import data.Item;
import data.Vase;
import data.Statue;
import data.Painting;

public class InventoryManager {
    private String fileName;
    private ArrayList<Item> items;

    InventoryManager(String file) {
        this.fileName = file;
        this.items = new ArrayList<>();
    }

    public void readingRecords() {
        File inputFile = new File(fileName);
        try {
            Scanner input = new Scanner(inputFile);
            readItem(input);
            input.close();
        } catch(FileNotFoundException error) {
            System.out.println("Archivo inexistente.");
            System.exit(0);
        }
    }

    private void readItem(Scanner scan) {
        while(scan.hasNext()) {
            processLine(scan.nextLine());
        }
    }

    private void processLine(String line) {
        Scanner scan = new Scanner(line).useDelimiter(",");
        String category = scan.next().trim().toLowerCase();
        createItem(category, scan);

        scan.close();
    }

    private void createItem(String category, Scanner scan) {
        String creator = scan.next();
        float value = Float.parseFloat(scan.next().trim());

        Item item = null;
        switch(category) {
        case "vase":
            int height = Integer.parseInt(scan.next().trim());
            String material = scan.next();
            item = new Vase(value, creator, height, material);
            break;
        case "statue":
            int weight = Integer.parseInt(scan.next().trim());
            String color = scan.next();
            item = new Statue(value, creator, weight, color);
            break;
        case "painting":
            int paintHeight = Integer.parseInt(scan.next().trim());
            int width = Integer.parseInt(scan.next().trim());
            boolean isWaterColor = Boolean.parseBoolean(scan.next().trim());
            boolean isFramed = Boolean.parseBoolean(scan.next().trim());
            item = new Painting(value, creator, paintHeight, width, isWaterColor, isFramed);
            break;
        default:
            System.out.println("Unknown category --" + category);
        }
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
