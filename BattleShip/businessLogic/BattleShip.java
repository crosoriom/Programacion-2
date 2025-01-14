import java.util.ArrayList;
import java.util.Random;

public class BattleShip {
	private Panel ocean = new Panel(5, 5);
	private ArrayList<Ship> ships = new ArrayList<>();
	private UserInterface userInterface = new UserInterface();
	private Random random = new Random();

	public void setup() {	//Coloca 3 barcos en posiciones aleatorias
		for(int i = 0; i < 3; i++) {
			Ship ship = new Ship(3);			
			String point = ocean.getRandomCell();
			int[] coordinate = ocean.cellCoordinate(point);
			if(ocean.selectDirection() == 0) {	//El barco se colocará en posición horizontal
				ship.addPosition(point);
				if(coordinate[1] == 4) {
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] - 1));
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] - 2));
				} else if(coordinate[1] == 0) {
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] + 1));
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] + 2));
				} else {
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] + 1));
					ship.addPosition(ocean.getCell(coordinate[0], coordinate[1] - 1));					
				}
			} else {							//El barco se colocará en posición vertical
				ship.addPosition(point);
				if(coordinate[0] == 4) {		
					ship.addPosition(ocean.getCell(coordinate[0] - 1, coordinate[1]));
					ship.addPosition(ocean.getCell(coordinate[0] - 2, coordinate[1]));
				} else if(coordinate[0] == 0) {
					ship.addPosition(ocean.getCell(coordinate[0] + 1, coordinate[1]));
					ship.addPosition(ocean.getCell(coordinate[0] + 2, coordinate[1]));
				} else {
					ship.addPosition(ocean.getCell(coordinate[0] + 1, coordinate[1]));
					ship.addPosition(ocean.getCell(coordinate[0] - 1, coordinate[1]));					
				}
			}
			ships.add(ship);
		}
	}

	public void start() {
		int kills = 0;
		int turn = 0;
		boolean win = false;
		while(!win) {
			boolean hit = false;
			if(turn >= 20) {
				userInterface.lose();
				userInterface.score(kills, turn);
				break;
			}
			String guess = userInterface.guess();
			for(Ship ship : ships) {
				if(ship.autocheck(guess)) {
					hit = true;
					if(ship.getHealth() > 1) {
						userInterface.hit();
						ship.hit(guess);
						break;
					}
					userInterface.kill();
					ships.remove(ship);
					kills++;
					break;
				}
			}
			if(!hit) {
				userInterface.fail();
			}
			turn++;
			if(ships.size() == 0) {
				userInterface.win();
				userInterface.score(kills, turn);
				win = true;
			}
		}
	}
}