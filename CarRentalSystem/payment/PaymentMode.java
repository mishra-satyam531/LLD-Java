package CarRentalSystem.payment;

import CarRentalSystem.models.Bill;

public interface PaymentMode {
    public boolean makePayment(Bill bill);
}
