package data;

public class Vase {
    private float value;
    private String creator;
    private int height;
    private String material;

    public Vase(float price, String author, int dimension, String matter) {
        this.value = price;
        this.creator = author;
        this.height = dimension;
        this.material = matter;
    }

    public String toString() {
        return "Vase [value= " + value + ", creator: " + creator + ", height= " + height + ", material: " + material + "]";
    }
}
