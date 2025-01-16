package ui;

public class Runner {
    public static void main(String[] args) {
        // Ruta del archivo de datos
        String filePath = "sillas.txt";

        // Inicializa la interfaz de usuario
        UserInterface userInterface = new UserInterface();

        // Inicia la interfaz con el archivo de datos
        userInterface.start(filePath);
    }
}
