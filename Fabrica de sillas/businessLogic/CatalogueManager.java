package businessLogic;

import data.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogueManager {
    private ArrayList<Chair> chairs;
    /**
     * Carga las sillas desde un archivo de texto.
     * El formato esperado es: referencia, tipo, precio, calificación, (atributos adicionales según el tipo)
     */
    public void loadChairs(String filePath) {
        FileReader fileReader = new FileReader();
        try {
            List<String[]> data = fileReader.readFile(filePath);
            for (String[] row : data) {
                Chair<?> chair = parseChair(row); // Procesar cada fila
                if (chair != null) {
                    chairs.add(chair); // Agregar la silla a la lista
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar las sillas: " + e.getMessage());
        }
    }

    /**
     * Obtiene todas las sillas de una categoría específica.
     * @param category Nombre de la categoría (presidencial, gerencial, etc.)
     * @return Lista de sillas que pertenecen a la categoría
     */
    public List<Chair<?>> getChairsByCategory(String category) {
        List<Chair<?>> result = new ArrayList<>();
        for (Chair<?> chair : chairs) {
            if (chair.getClass().getSimpleName().equalsIgnoreCase(category + "Chair")) {
                result.add(chair);
            }
        }
        return result;
    }

    /**
     * Convierte una fila del archivo de texto en un objeto de tipo Chair.
     * @param row Array de strings que representa una fila del archivo
     * @return Objeto de tipo Chair correspondiente a la fila
     */
    private Chair<?> parseChair(String[] row) {
        try {
            // Extraer los campos según el orden correcto
            String reference = row[0].trim(); // La referencia es el primer campo
            String type = row[1].trim().toLowerCase(); // El tipo es el segundo campo
            float price = Float.parseFloat(row[2].trim()); // El precio es el tercer campo
            float qualification = Float.parseFloat(row[3].trim()); // La calificación es el cuarto campo

            // Procesar el tipo de silla y sus atributos adicionales
            switch (type) {
                case "presidencial": // Presidencial
                    String imported = row[4].trim(); // Atributo adicional: si/no
                    return new PresidentialChair(reference, price, qualification, imported);
                case "gerencial": // Gerencial
                    return new ManagerialChair(reference, price, qualification);
                case "secretarial": // Secretarial
                    return new SecretarialChair(reference, price, qualification);
                case "tandem": // Tandem
                    int seats = Integer.parseInt(row[4].trim()); // Atributo adicional: número de asientos
                    return new TandemChair(reference, price, qualification, seats);
                case "ruedas": // Wheelchair
                    String traction = row[4].trim(); // Atributo adicional: tracción manual/automática
                    return new Wheelchair(reference, price, qualification, traction);
                default:
                    System.err.println("Tipo de silla desconocido: " + type);
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Error al parsear la fila: " + String.join(", ", row) + " - " + e.getMessage());
            return null;
        }
    }
}
