package data;

public class ManagerialChair extends CatalogueChair {
    public ManagerialChair(String reference, float price, float qualification) {
        super(reference, price, qualification);
    }

    @Override
    public String toString() {
    	return "Gerencial --\t" + super.toString();
    }

    @Override
    public String removeFromCatalogue() {
	    if(qualification < 4 || price > 300000)
            return "Remover";
        else
            return "Mantener";
    }
}
