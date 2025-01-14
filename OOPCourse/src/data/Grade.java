public class Grade {
    private double value;
    private double weight;

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    Grade(double value, int weight) {
        this.value = value;
        this.weight = weight / 100.0;
    }
}