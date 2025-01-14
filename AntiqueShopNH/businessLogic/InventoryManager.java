package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import data.Vase;
import data.Statue;
import data.Painting;

public class InventoryManager {
    private String fileName;
    private ArrayList<Statue> statues;
    private ArrayList<Vase> vases;
    private ArrayList<Painting> paintings;

    InventoryManager(String file) {
        this.fileName = file;
        this.vases = new ArrayList<>();
        this.statues = new ArrayList<>();
        this.paintings = new ArrayList<>();
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

        switch(category) {
            case "vase":
                createVase(scan);
                break;
            case "statue":
                createStatue(scan);
                break;
            case "painting":
                createPainting(scan);
                break;
            default:
                System.out.println("Unknown category --" + category);
                System.exit(1);
        }
        scan.close();
    }

    private void createVase(Scanner scan) {
        String creator = scan.next();
        float value = Float.parseFloat(scan.next().trim());
        int height = Integer.parseInt(scan.next().trim()); 
        String material = scan.next();
        Vase newVase = new Vase(value, creator, height, material);
        vases.add(newVase);
    }

    private void createStatue(Scanner scan) {
        String creator = scan.next();
        float value = Float.parseFloat(scan.next().trim());
        int weight = Integer.parseInt(scan.next().trim()); 
        String color = scan.next();
        Statue newStatue = new Statue(value, creator, weight, color);
        statues.add(newStatue);
    }

    private void createPainting(Scanner scan) {
        String creator = scan.next();
        float value = Float.parseFloat(scan.next().trim());
        int height = Integer.parseInt(scan.next().trim()); 
        int weight = Integer.parseInt(scan.next().trim()); 
        boolean isWaterColor = Boolean.parseBoolean(scan.next().trim());
        boolean isFramed = Boolean.parseBoolean(scan.next().trim());
        Painting newPainting= new Painting(value, creator, height, weight, isWaterColor, isFramed);
        paintings.add(newPainting);
    }

    public ArrayList<Vase> getVases() {
        return vases;
    }

    public ArrayList<Statue> getStatues() {
        return statues;
    }

    public ArrayList<Painting> getPaintings() {
        return paintings;
    }
}
