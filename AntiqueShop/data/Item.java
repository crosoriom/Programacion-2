package data;

public class Item {
	protected float value;
	protected String creator;

	public Item(float value, String creator) {
		this.value = value;
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Value= " + value + ", creator: " + creator;
	}
}