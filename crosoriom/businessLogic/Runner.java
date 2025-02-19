package businessLogic;

import data.*;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        FileReader reader = new FileReader("characters.txt");
        ArrayList<TypeCharacter> characters = new ArrayList<>();
        Parser parser = new Parser();

        ArrayList<String> lines = reader.getLines();
        for(String line : lines) {
            TypeCharacter character = parser.parseCharacter(line);
            characters.add(character);
        }
        for(TypeCharacter character : characters) {
            if(character.canBuyWeapon()) {
                System.out.println(character.getID() + ", " + character.availableWeapon());
            }else {
                System.out.println(character.getID() + ", nothing");
            }
        }
    }
}
