import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		int option;
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new UserInterface();
		BattleShip game = new BattleShip();

		do{
			userInterface.menu();
			option = scanner.nextInt();

			switch(option) {
				case 1:
					userInterface.startGame();
					game.setup();
					game.start();
					break;
				case 2:
					userInterface.tutorial();
					break;
			}
		} while(option != 3);
	}
}