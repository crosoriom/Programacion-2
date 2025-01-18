package data;

public abstract class CatalogueChair implements Chair<CatalogueChair> {
    protected String reference;
    protected float price;
    protected float qualification;

    public CatalogueChair(String reference, float price, float qualification) {
        this.reference = reference;
        this.price = price;
        this.qualification = qualification;
    }

    public abstract String removeFromCatalogue();

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
        return price;
    }
}
