package CarRentalSystem;

public class Bill {
    private Reservation reservation;
    private double totalAmount;
    private boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalAmount = computeAmout();
        this.isPaid = false;
    }
    

    private double computeAmout() {
        long diff = reservation.getDateBookedTo().getTime() - reservation.getDateBookedFrom().getTime();

        long days = diff / (1000 * 60 * 60 * 24);
        double amount = days * 1000.0;

        return amount;
    }

    public double getAmount() {
        return totalAmount;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
