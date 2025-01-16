package ui;

import data.CatalogueChair;
import data.PresidentialChair;
import data.ManagerialChair;
import data.SecretarialChair;
import data.TandemChair;
import data.Wheelchair;

import java.util.ArrayList;
import java.util.List;

public class CatalogueManager {
    private List<CatalogueChair> chairs;

    public CatalogueManager() {
        this.chairs = new ArrayList<>();
    }

    /**
     * Carga las sillas desde un archivo de texto.
     * El formato esperado es: tipo, referencia, precio, calificación, (atributos adicionales)
     */
    public void loadChairs(String filePath) {
        FileReader fileReader = new FileReader();
        try {
            List<String[]> data = fileReader.readFile(filePath);
            for (String[] row : data) {
                CatalogueChair chair = parseChair(row);
                if (chair != null) {
                    chairs.add(chair);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar las sillas: " + e.getMessage());
        }
    }

    /**
     * Agrega una silla al catálogo.
     */
    public void addChair(CatalogueChair chair) {
        if (chair != null) {
            chairs.add(chair);
        }
    }

    /**
     * Obtiene todas las sillas de una categoría específica.
     */
    public List<CatalogueChair> getChairsByCategory(String category) {
        List<CatalogueChair> result = new ArrayList<>();
        for (CatalogueChair chair : chairs) {
            if (chair.getClass().getSimpleName().equalsIgnoreCase(category + "Chair")) {
                result.add(chair);
            }
        }
        return result;
    }

    /**
     * Devuelve el estado del catálogo con "Remover" o "Mantener" para cada silla.
     */
    public List<String> getCatalogueStatus() {
        List<String> statusList = new ArrayList<>();
        for (CatalogueChair chair : chairs) {
            String status = chair.getReference() + ", " + chair.removeFromCatalogue();
            statusList.add(status);
        }
        return statusList;
    }

    /**
     * Lista todas las sillas del catálogo.
     */
    public List<CatalogueChair> getChairs() {
        return new ArrayList<>(chairs); // Copia para evitar modificaciones directas
    }

    /**
     * Convierte una fila del archivo en un objeto de tipo `CatalogueChair`.
     */
    private CatalogueChair parseChair(String[] row) {
        try {
            String type = row[0].trim();
            String reference = row[1].trim();
            float price = Float.parseFloat(row[2].trim());
            float qualification = Float.parseFloat(row[3].trim());

            switch (type.toLowerCase()) {
                case "presidential":
                    String imported = row[4].trim();
                    return new PresidentialChair(reference, price, qualification, imported);
                case "managerial":
                    return new ManagerialChair(reference, price, qualification);
                case "secretarial":
                    return new SecretarialChair(reference, price, qualification);
                case "tandem":
                    int seats = Integer.parseInt(row[4].trim());
                    return new TandemChair(reference, price, qualification, seats);
                case "wheelchair":
                    String traction = row[4].trim();
                    return new Wheelchair(reference, price, qualification, traction);
                default:
                    System.err.println("Tipo de silla desconocido: " + type);
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error al parsear la fila: " + e.getMessage());
            return null;
        }
    }
}
