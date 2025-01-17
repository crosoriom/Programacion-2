package businessLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String[]> readFile(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Ignorar líneas en blanco
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Dividir los campos usando coma como separador
                String[] parts = line.split(",");
                data.add(parts);
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage());
        }

        return data;
    }
}
