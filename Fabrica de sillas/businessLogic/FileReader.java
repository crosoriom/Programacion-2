package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    ArrayList<String> lines = new ArrayList<>();

    public FileReader(String file) {
        File inputFile = new File(file);
        try {
            Scanner input = new Scanner(inputFile);
            readLines(input);
            input.close();
        } catch(FileNotFoundException error) {
            System.out.println("Archivo inexistente");
            System.exit(0);
        }
    }

    private void readLines(Scanner scan) {
        while(scan.hasNext()) {
            lines.add(scan.nextLine());
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}
