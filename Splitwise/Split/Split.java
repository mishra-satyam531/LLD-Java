package Splitwise.Split;

import Splitwise.Models.User;

public abstract class Split {
    private User user;
    protected double amount;
    
    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
