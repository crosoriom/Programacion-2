package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.CatalogueChair;

public class CatalogueManager {
    private List<CatalogueChair> chairs;

    public CatalogueManager() {
        this.chairs = new ArrayList<>();
    }

    public void loadChairs() {
        FileReader fileReader = new FileReader();

        try {
            // Leemos el archivo "sillas.txt" 
            List<String[]> data = fileReader.readFile("sillas.txt");
            for (String[] row : data) {
                String reference = row[0];
                float price = Float.parseFloat(row[1]);
                float qualification = Float.parseFloat(row[2]);
                String type = row[3];

                CatalogueChair chair;
                switch (type) {
                    case "Managerial":
                        chair = new ManagerialChair(reference, price, qualification);
                        break;
                    case "Presidential":
                        String imported = row[4];
                        chair = new PresidentialChair(reference, price, qualification, imported);
                        break;
                    case "Secretarial":
                        chair = new SecretarialChair(reference, price, qualification);
                        break;
                    case "Tandem":
                        int seats = Integer.parseInt(row[4]);
                        chair = new TandemChair(reference, price, qualification, seats);
                        break;
                    case "Wheelchair":
                        String traction = row[4];
                        chair = new Wheelchair(reference, price, qualification, traction);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de silla desconocido: " + type);
                }

                chairs.add(chair);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las sillas: " + e.getMessage());
        }
    }

    public List<CatalogueChair> getChairs() {
        return chairs;
    }
}
