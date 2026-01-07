package CarRentalSystem;

public class CashPayment implements PaymentMode {

    @Override
    public boolean makePayment(Bill bill) {
        System.out.println("Paid " + bill.getAmount() + " via cash");
        return true;
    }
    
}
