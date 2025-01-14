package data;

public class Statue {
    private float value;
    private String creator;
    private int weight;
    private String color;

    public Statue(float price, String author, int dimension, String colour) {
        this.value = price;
        this.creator = author;
        this.weight = dimension;
        this.color = colour;
    }

    public String toString() {
        return "Statue [value= " + value + ", creator: " + creator + ", weight= " + weight + ", color: " + color + "]";
    }
}
