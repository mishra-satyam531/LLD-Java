package Splitwise;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Balance> userVsBalance;
    private double totalYourExpense;
    private double totalPayment;
    private double totalOwe;
    private double totalGetBack;

    public UserExpenseBalanceSheet() {
        this.userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalPayment = 0;
        totalOwe = 0;
        totalGetBack = 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
    
}
