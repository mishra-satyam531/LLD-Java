package Splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Split.PercentSplit;
import Splitwise.Split.Split;
import Splitwise.Split.User;
import Splitwise.Enums.ExpenseType;
import Splitwise.Expense.EqualExpense;
import Splitwise.Expense.ExactExpense;
import Splitwise.Expense.Expense;
import Splitwise.Expense.PercentExpense;

public class ExpenseManager {
    private List<Expense> expenseList;
    private Map<String, User> userMap;
    
    public ExpenseManager() {
        this.expenseList = new ArrayList<>();
        this.userMap = new HashMap<>();
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
 
    public void addUser(User user, String userId) {
        userMap.put(userId, user);
    }

    public Expense createExpense(ExpenseType type, double amount, User paidBy, List<Split> splits, String label) {
        Expense expense = null;
        switch (type) {
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount * 100 / totalSplits)) / 100.0;
                for(Split split : splits) {
                    split.setAmount(splitAmount);
                }

                expense = new EqualExpense(label, amount, paidBy, splits);
                break;
            case EXACT:
                expense = new ExactExpense(label, amount, paidBy, splits);
                break;
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit pSplit = (PercentSplit) split;
                    split.setAmount((amount * pSplit.getPercentage()) / 100.0);
                }
                expense = new PercentExpense(label, amount, paidBy, splits);
                break;
            default:
                System.out.println("Expense type not available");
                return null;
        }

        if (expense == null || !expense.validate()) {
            return null;
        }
        
        expenseList.add(expense);
        updateExpense(expense);
        return expense;
    }

    public void updateExpense(Expense expense) {
        User paidBy = expense.getPaidBy();

        for(Split split : expense.getSplits()) {
            User paidTo = split.getUser();
            double amount = split.getAmount();

            if(paidBy.getUserId().equals(paidTo.getUserId())) {
                continue;
            }

            paidBy.getBalances().put(paidTo.getUserId(), paidBy.getBalances().getOrDefault(paidTo.getUserId(), (double) 0) + amount);

            paidTo.getBalances().put(paidBy.getUserId(), paidTo.getBalances().getOrDefault(paidBy.getUserId(), (double) 0) - amount);
        }
    }
}
