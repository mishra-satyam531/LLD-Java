package CarRentalSystem.payment;

import CarRentalSystem.models.Bill;

public class CreditCardPayment implements PaymentMode {

    @Override
    public boolean makePayment(Bill bill) {
        System.out.println("Paid " + bill.getAmount() + " via credit card");

        bill.setPaid(true);
        return true;
    }
}
