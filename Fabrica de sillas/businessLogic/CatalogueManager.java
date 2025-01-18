package businessLogic;

import data.*;
import java.util.ArrayList;

public class CatalogueManager {
    private ArrayList<CatalogueChair> presidentialChairs = new ArrayList<>();
    private ArrayList<CatalogueChair> managerialChairs = new ArrayList<>();
    private ArrayList<CatalogueChair> secretarialChairs = new ArrayList<>();
    private ArrayList<Chair> catalogueChairs = new ArrayList<>();
    private ArrayList<VarietyChair> tandemChairs = new ArrayList<>();
    private ArrayList<VarietyChair> wheelChairs = new ArrayList<>();
    private ArrayList<Chair> varietyChairs = new ArrayList<>();

    public CatalogueManager(String fileName) {
        loadChairs(fileName);
    }
    /**
     * Carga las sillas desde un archivo de texto.
     * El formato esperado es: referencia, tipo, precio, calificación, (atributos adicionales según el tipo)
     */
    public void loadChairs(String filePath) {
        FileReader file = new FileReader(filePath);
        ArrayList<String> lines = file.getLines();
        for(String line : lines)
            parseChair(line);
        catalogueChairs.addAll(presidentialChairs);
        catalogueChairs.addAll(managerialChairs);
        catalogueChairs.addAll(secretarialChairs);

        varietyChairs.addAll(tandemChairs);
        varietyChairs.addAll(wheelChairs);
    }

    /**
     * Convierte una fila del archivo de texto en un objeto de tipo Chair.
     * @param row Array de strings que representa una fila del archivo
     * @return Objeto de tipo Chair correspondiente a la fila
     */
    private void parseChair(String rawLine) {
        String[] arguments = rawLine.split(",");
        // Seleccionar el tipo de silla
        String type = arguments[1].toLowerCase().trim();
        // Procesar el tipo de silla y sus atributos adicionales
        switch (type) {
        case "presidencial":
            CatalogueChair chairP = new PresidentialChair(arguments[0], Float.parseFloat(arguments[2]), Float.parseFloat(arguments[3]), arguments[4]);
            presidentialChairs.add(chairP);
            break;
        case "gerencial":
            CatalogueChair chairG = new ManagerialChair(arguments[0], Float.parseFloat(arguments[2]), Float.parseFloat(arguments[3]));
            managerialChairs.add(chairG);
            break;
        case "secretarial":
            CatalogueChair chairS = new SecretarialChair(arguments[0], Float.parseFloat(arguments[2]), Float.parseFloat(arguments[3]));
            secretarialChairs.add(chairS);
            break;
        case "tandem":
            VarietyChair chairI = new TandemChair(arguments[0], Float.parseFloat(arguments[2]), Float.parseFloat(arguments[3]), Integer.parseInt(arguments[4]));
            tandemChairs.add(chairI);
            break;
        case "wheel":
            VarietyChair chairW = new Wheelchair(arguments[0], Float.parseFloat(arguments[2]), Float.parseFloat(arguments[3]), arguments[4]);
            wheelChairs.add(chairW);
            break;
        default:
            System.err.println("Tipo de silla desconocido: " + type);
            break;
        }
    }
    /**
     * Obtiene todas las sillas de una categoría específica.
     * @param category Nombre de la categoría (presidencial, gerencial, etc.)
     * @return Lista de sillas que pertenecen a la categoría
     */
    public void getChairsByCategory(String category) {
        switch (category) {
        case "catalogue":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "variety":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "presidential":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "managerial":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "secretarial":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "tandem":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        case "wheel":
            for(Chair chair : catalogueChairs) 
                System.out.println(chair.toString());
        }
    }
}
