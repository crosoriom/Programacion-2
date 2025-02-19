package businessLogic;

import data.*;

public class Parser {
    public TypeCharacter parseCharacter(String rawLine) {
        String[] arguments = rawLine.split(",");
        // Seleccionar el tipo de personaje
        String type = arguments[1].toLowerCase().trim();
        // Extrae los atributos
        String id = arguments[0];
        int level = Integer.parseInt(arguments[2].trim());
        int gold = Integer.parseInt(arguments[3].trim());

        switch (type) {
        case "wizard":
            Wizard wizard = new Wizard(id, level, gold);
            return wizard;
        case "warrior":
            Warrior warrior = new Warrior(id, level, gold);
            return warrior;
        case "support":
            Support supp = new Support(id, level, gold);
            return supp;
        default:
            System.out.println("Clase no encontrada");
            return null;
        }
    }
}
