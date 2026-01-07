package CarRentalSystem;

public class CreditCardPayment implements PaymentMode {

    @Override
    public boolean makePayment(Bill bill) {
        System.out.println("Paid " + bill.getAmount() + " via credit card");
        return true;
    }
}
