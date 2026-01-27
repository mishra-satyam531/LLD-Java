package Splitwise.Models;

public class Balance {
    private double amount;
    private double amountOwe;
    private double amountGetBack;

    public Balance() {
        this.amount = 0.0;
        this.amountOwe = 0.0;
        this.amountGetBack = 0.0;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }

}
