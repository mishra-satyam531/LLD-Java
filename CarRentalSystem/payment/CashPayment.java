package CarRentalSystem.payment;

import CarRentalSystem.models.Bill;

public class CashPayment implements PaymentMode {

    @Override
    public boolean makePayment(Bill bill) {
        System.out.println("Paid " + bill.getAmount() + " via cash");

        bill.setPaid(true);
        return true;
    }
    
}
