package data;

public class PresidentialChair extends CatalogueChair {
    private String imported;

    public PresidentialChair(String reference, float price, float qualification, String imported) {
        super(reference, price, qualification);
        this.imported = imported;
    }

    @Override
    public String toString() {
    	return "Presidencial --\t" + super.toString() + "Importada: " + imported;
    }

    @Override
    public String removeFromCatalogue() {
        if((isImported() && qualification < 3.5) || price > 400000)
            return "Remover";
        else
            return "Mantener";
    }

    private boolean isImported() {
        return this.imported.equals("si");
    }
}
