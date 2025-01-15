package data;

public class SecretarialChair extends CatalogueChair {
    public SecretarialChair(String reference, float price, float qualification) {
        super(reference, price, qualification);
    }

    @Override
    public String removeFromCatalogue() {
        if(qualification < 3 || price > 200000)
            return "Remover";
        else
            return "Mantener";
    }
}
