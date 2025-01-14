import java.util.ArrayList;

public class Ship {
	private ArrayList<String> position = new ArrayList<>();
	private int health;

	Ship(int durability) {
		this.health = durability;
	}

	public ArrayList<String> getPosition() {
		return this.position;
	}

	public void addPosition(String point) {
		position.add(point);
	}

	public int getHealth() {
		return this.health;
	}

	public void hit(String point) {
		health = health - 1;
		position.remove(point);
	}

	public boolean autocheck(String point) {
		for(String section : position) {
			if(section.equals(point)){
				return true;
			}
		}
		return false;
	}
}