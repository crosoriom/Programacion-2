package businessLogic;
import data.*;
import ui.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        CSVFileReader fileReader = new CSVFileReader();
        Orderer orderer = new Orderer();
        UserInterface ui = new UserInterface();

        try {
            students = fileReader.readCSV("datos2.txt");
        } catch(IOException e) {
            System.out.println("Error al leer archivo csv: " + e.getMessage());
            System.exit(1);
        }

        ui.menu();
        int option = Integer.parseInt(ui.readOption());
        switch(option) {
            case 1:
                orderer.orderByID(students);
                break;
            case 2:
                orderer.orderByName(students);
                break;
            case 3:
                orderer.orderByLastName(students);
                break;
            case 4:
                orderer.orderByBirtday(students);
                break;
            case 5:
                orderer.orderByPapa(students);
                break;
            case 6:
                orderer.orderByZodiacSign(students);
                break;
            default:
                ui.wrongOption();
                break;
        }
    }
}
