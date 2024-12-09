import java.util.Scanner;
import java.util.ArrayList;

public class Runner {
	public static void main(String[] args) {
		OOPcourse course = new OOPcourse();
		Scanner scanner = new Scanner(System.in);
		int option;

		System.out.printf("Bienvenido profesor %s!%n", course.getProfessor());
		System.out.printf("Esta es la aplicación de notas para el curso de %s(%s).%n", course.getCourseName(), course.getID());

		do {
			System.out.printf("%n   Menú:%n");
            System.out.println("1. Agregar estudiante.");
            System.out.println("2. Agregar nota a un estudiante.");
            System.out.println("3. Calcular nota final de un estudiante.");
            System.out.println("4. Listar estudiantes registrados.");
            System.out.println("5. Mostrar la nota promedio del curso.");
            System.out.println("6. Salir.");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

			switch(option) {
				case 1:
					course.addStudent(scanner);
					System.out.println("Estudiante agregado con éxito.");
					break;

				case 2:
					course.addStudentGrade(scanner);
					break;

				case 3:
					course.calculateStudentGrade(scanner);
					break;

				case 4:
					course.listStudents();
					break;

				case 5:
					double courseGrade = course.calculateCourseGrade();
					System.out.printf("La nota promedio del curso es: %.4f", courseGrade);
					break;
			}
		} while(option != 6);

		scanner.close();
	}
}
