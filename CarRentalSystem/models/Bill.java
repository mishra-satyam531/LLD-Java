package CarRentalSystem.models;

public class Bill {
    private Reservation reservation;
    private double totalAmount;
    private boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalAmount = computeAmount();
        this.isPaid = false;
    }
    

    private double computeAmount() {
        long diff = reservation.getDateBookedTo().getTime() - reservation.getDateBookedFrom().getTime();

        double days = (double) diff / (1000 * 60 * 60 * 24);
        
        double billableDays = Math.ceil(days);
        
        double amount = billableDays * 1000.0;
        return amount;
    }

    public double getAmount() {
        return totalAmount;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
