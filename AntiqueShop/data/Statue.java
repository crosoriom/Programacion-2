package data;

public class Statue extends Item {
	private int weight;
	private String color;

	public Statue(float value, String creator, int weight, String color) {
		super(value, creator);
		this.weight = weight;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Statue --\t" + super.toString() + ", weight= " + weight + ", color: " + color;
	}
}