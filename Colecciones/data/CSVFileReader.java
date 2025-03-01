package data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
    public static List<Student> readCSV(String file) throws IOException {
        List<Student> students = new ArrayList<>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        while((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String id = data[0];
            String lastNames = data[1];
            String names = data[2];
            LocalDate birthday = LocalDate.parse(data[3]);
            double papa = Double.parseDouble(data[4]);

            Student student = new Student(id, names, lastNames, birthday, papa);
            students.add(student);
        }

        return students;
    }
}
