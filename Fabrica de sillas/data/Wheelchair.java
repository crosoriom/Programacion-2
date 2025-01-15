package data;

public class Wheelchair extends VarietyChair {
    private String traction;

    public Wheelchair(String reference, float price, float qualification, String traction) {
        super(reference, price, qualification);
        this.traction = traction;
    }

    public String getTraction() {
        return traction;
    }
}
