package data;

public class Wheelchair extends VarietyChair {
    private String traction;

    public Wheelchair(String reference, float price, float qualification, String traction) {
        super(reference, price, qualification);
        this.traction = traction;
    }

    @Override
    public String toString() {
    	return "Silla de ruedas --\t" + super.toString() + "Tracción: " + traction;
    }

    public String getTraction() {
        return traction;
    }
}
