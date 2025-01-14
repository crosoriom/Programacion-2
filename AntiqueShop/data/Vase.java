package data;

public class Vase extends Item {
	private int height;
	private String material;

	public Vase(float value, String creator, int height, String material) {
		super(value, creator);
		this.height = height;
		this.material = material;
	}

	@Override
	public String toString() {
		return "Vase --\t" + super.toString() + ", height= " + height + ", material: " + material;
	}
}