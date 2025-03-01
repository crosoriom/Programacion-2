package businessLogic;
import data.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Orderer {
    public void orderByID(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getID));
        System.out.println("Ordenamiento por ID.");
        showStudents(students);
    }

    public void orderByName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getNames));
        System.out.println("Ordenamiento por nombres.");
        showStudents(students);
    }

    public void orderByLastName(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getLastNames));
        System.out.println("Ordenamiento por apellidos.");
        showStudents(students);
    }

    public void orderByBirtday(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getBirthday));
        System.out.println("Ordenamiento por fecha de nacimiento.");
        showStudents(students);
    }

    public void orderByPapa(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getPAPA));
        System.out.println("Ordenamiento por promedio académico.");
        showStudents(students);
    }

    public void orderByZodiacSign(List<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getZodiacSign));
        System.out.println("Ordenamiento por signo del zodiaco.");
        showStudents(students);
    }

    public void showStudents(List<Student> students) {
        System.out.printf("%-15s %-25s %-25s %-15s %-6s %-15s\n", 
            "ID", "NOMBRES", "APELLIDOS", "FECHA NAC.", "PROMEDIO", "SIGNO ZODIACAL");
        System.out.println("---------------------------------------------------------------------------------");
        for(Student s : students) {
            System.out.printf("%-15s %-25s %-25s %-15s %-3.2f %-15s\n",
                    s.getID(),
                    s.getNames(),
                    s.getLastNames(),
                    s.getBirthday(),
                    s.getPAPA(),
                    s.getZodiacSign());
        }
    }
}
