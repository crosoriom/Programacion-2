import java.util.Scanner;

public class UserInterface {
	private Scanner scanner = new Scanner(System.in);

	public void menu() {
		System.out.printf("\n\n");
		System.out.println("¡Bienvenido a la batalla naval definitiva!");
		System.out.println("Seleccione una opción:");
		System.out.println("1. Empezar a jugar");
		System.out.println("2. Cómo jugar");
		System.out.println("3. Salir");
	}

	public void tutorial() {
		System.out.printf("\n\n");
		System.out.println("Cómo jugar:");
		System.out.println("El juego consiste en intentar hundir los 3 barcos antes del turno 20.");
		System.out.println("Los barcos están distribuidos de manera aleatoria en el tablero de 5 x 5.");
		System.out.println("Cuando el juego se lo indique, ingrese la casilla a la que quiera disparar.");
		System.out.println("Ej: A5");
		System.out.println("El juego le dirá si su tiro golpeó, falló o hundió algún barco.");
	}

	public void startGame() {
		System.out.printf("\n\n");
		System.out.println("¡Que bueno tenerlo de vuelta, Comandante.!");
		System.out.println("¡La tripulación está a su disposición!");
	}

	public String guess() {
		System.out.println("¿A que región desea disparar?");
		return scanner.next();
	}

	public void fail() {
		System.out.println("¡Hemos fallado!");
		System.out.println("Recargando...");
		System.out.println("¡Armas a punto!");
	}

	public void hit() {
		System.out.println("¡En el blanco!");
		System.out.println("¡No hay que dejar que escape, Comandante!");
	}

	public void kill() {
		System.out.println("¡Lo hemos reventado!");
		System.out.println("¡Así se hace!");
	}

	public void win() {
		System.out.println("¡Hemos hundido todos los cruceros!");
		System.out.println("¡VICTORIA!");
	}

	public void lose() {
		System.out.println("Los navios enemigos han escapado.");
		System.out.println("¡En la siguiente batalla no huirán!");
	}

	public void score(int kills, int guesses) {
		System.out.println("Navios Hundidos:");
		System.out.println(kills);
		System.out.println("Disparos realizados:");
		System.out.println(guesses);
	}
}