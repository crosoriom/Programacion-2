package data;

public class TandemChair extends VarietyChair {
    private int seats;

    public TandemChair(String reference, float price, float qualification, int seats) {
        super(reference, price, qualification);
        this.seats = seats;
    }

    @Override
    public String toString() {
    	return "Tandem --\t" + super.toString() + "Número de puestos:" + seats;
    }

    public int getSeats() {
        return seats;
    }
}
