package BookMyShow.strategies;

public class CreditCardPaymentService implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " via Credit Card");
    }
    
}
