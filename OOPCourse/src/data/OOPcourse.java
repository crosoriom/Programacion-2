import java.util.Scanner;
import java.util.ArrayList;

public class OOPcourse {
	private ArrayList<Student> students = new ArrayList<>();
	private String professor = "Jairo";
	private String courseName = "Programación II";
	private String id = "4100547";
	private double courseGrade = 0;

	public String getProfessor() {
		return this.professor;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public String getID() {
		return this.id;
	}

	public void addStudent(Scanner scanner) {
		students.add(new Student(scanner));
	}

	public void addStudentGrade(Scanner scanner) {
        int index = findStudentByID(students, scanner);
        if(index != -1) {
			System.out.println("Ingrese la nota(ej: 3.5): ");
			String stringValue = scanner.next();
			double value = Double.parseDouble(stringValue);
			System.out.println("Ingrese el peso de la nota(ej: 60): ");
			String stringWeight = scanner.next();
			int weight = Integer.parseInt(stringWeight);
        	students.get(index).addGrade(value, weight);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
	}

	public void calculateStudentGrade(Scanner scanner) {
        int index = findStudentByID(students, scanner);
        if(index != -1) {
        	double grade = students.get(index).finalGrade();
			System.out.printf("La nota final del estudiante es: %s.%n", grade);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
	}

	public void listStudents() {
		int i = 1;
		for(Student student : students) {
			System.out.printf("%d. %s %s %n", i, student.getName(), student.getID());
			i++;
		}
	}

	public double calculateCourseGrade() {
		double sum = 0;
		for(Student student : students) {
			sum = sum + student.finalGrade();
		}
		this.courseGrade = sum / students.size();
		return courseGrade;
	}

	private int findStudentByID(ArrayList<Student> students, Scanner scanner) {
		System.out.println("Ingrese el id del estudiante: ");
        String studentID = scanner.next();
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getID().equals(studentID)) {
				return i;
			}
		}
		return -1;
	}
}