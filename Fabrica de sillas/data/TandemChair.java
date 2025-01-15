package data;

public class TandemChair extends VarietyChair {
    private int seats;

    public TandemChair(String reference, float price, float qualification, int seats) {
        super(reference, price, qualification);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}
