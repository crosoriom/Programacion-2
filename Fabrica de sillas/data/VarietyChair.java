package data;

public class VarietyChair implements Chair<VarietyChair> {
    protected String reference;
    protected float price;
    protected float qualification;

    public VarietyChair(String reference, float price, float qualification) {
        this.reference = reference;
        this.price = price;
        this.qualification = qualification;
    }
    @Override
    public String toString() {
	    return "Reference: " + reference + "Price=" + price + "Qualification: " + qualification;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public float getQualification() {
        return qualification;
    }
}
