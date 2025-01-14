import java.util.Scanner;
import java.util.ArrayList;

public class Student {
    private ArrayList<Grade> grades = new ArrayList<>();
    private String name;
    private String id;
    private double finalGrade = 0;

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public void addGrade(double value, int weight) {
        grades.add(new Grade(value, weight));
    }

    public double finalGrade() {
        for(Grade grade : grades) {
            this.finalGrade = finalGrade + grade.getValue() * grade.getWeight();
        }
        return finalGrade;
    }

    // Crear un estudiante mediante interacción con el usuario
    Student(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        this.name = scanner.next();

        System.out.print("Ingrese el ID del estudiante: ");
        this.id = scanner.next();

    }
}