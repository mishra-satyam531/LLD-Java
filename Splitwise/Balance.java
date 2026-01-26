package Splitwise;

import java.util.Map;

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

    public void showBalance(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        System.out.println("---------------------------------------");
        
        boolean isEmpty = true;
        
        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {
            String friendId = entry.getKey();
            Balance balance = entry.getValue();
            
            if (balance.getAmount() == 0) {
                continue;
            }

            isEmpty = false;
            
            if (balance.getAmount() > 0) {
                System.out.println(friendId + " owes you: " + balance.getAmount());
            } else {
                System.out.println("You owe " + friendId + ": " + Math.abs(balance.getAmount()));
            }
        }

        if (isEmpty) {
            System.out.println("No balances found.");
        }
    }

}
