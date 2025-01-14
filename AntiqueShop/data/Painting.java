package data;

public class Painting extends Item {
	private int height;
	private int width;
	private boolean isWaterColor;
	private boolean isFramed;

	public Painting(float value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
		super(value, creator);
		this.height = height;
		this.width = width;
		this.isWaterColor = isWaterColor;
		this.isFramed = isFramed;
	}

	@Override
	public String toString() {
		String info1, info2;
		if(isWaterColor)
			info1 = "it's WaterColour";
		else
			info1 = "it's not WaterColour";
		if(isFramed)
			info2 = "it's Framed";
		else
			info2 = "it's not Framed";

		return "Painting --\t" + super.toString() + ", height= " + height + ", width= " + width + info1 + info2;
	}
}