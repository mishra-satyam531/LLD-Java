package BookMyShow.strategies;

public class UpiPaymentService implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " via UPI");
    }
    
}
