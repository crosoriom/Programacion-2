package data;

public class Painting {
    private float value;
    private String creator;
    private int height;
    private int weight;
    private boolean isWaterColor;
    private boolean isFramed;

    public Painting(float price, String author, int height, int weight, boolean waterColor, boolean frame) {
        this.value = price;
        this.creator = author;
        this.height = height;
        this.weight = weight;
        this.isWaterColor = waterColor;
        this.isFramed = frame;
    }

    public String toString() {
        return "Painting [value= " + value + ", creator: " + creator + ", height= " + height + ", weight= " + weight + ", isWaterColor: " + isWaterColor + ", isFramed: " + isFramed + "]";
    }
}
