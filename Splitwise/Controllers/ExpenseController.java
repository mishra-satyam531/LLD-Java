package Splitwise.Controllers;

import java.util.ArrayList;
import java.util.List;

import Splitwise.Enums.ExpenseType;
import Splitwise.Expense.EqualExpense;
import Splitwise.Expense.ExactExpense;
import Splitwise.Expense.Expense;
import Splitwise.Expense.PercentExpense;
import Splitwise.Models.User;
import Splitwise.Split.PercentSplit;
import Splitwise.Split.Split;

public class ExpenseController {
    BalanceSheetController balanceSheetController;
    List<Expense> expenses;

    public ExpenseController(BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
        this.expenses = new ArrayList<>();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, List<Split> splitDetails, ExpenseType type, User paidBy) {
        
        Expense expense = null;
        
        switch (type) {
            case EQUAL:
                int totalSplits = splitDetails.size();
                double splitAmount = ((double) Math.round(expenseAmount * 100 / totalSplits)) / 100.0;
                for(Split split : splitDetails) {
                    split.setAmount(splitAmount);
                }
                expense = new EqualExpense(expenseId, expenseAmount, paidBy, splitDetails);
                break;
                
            case EXACT:
                expense = new ExactExpense(expenseId, expenseAmount, paidBy, splitDetails);
                break;
                
            case PERCENT:
                for(Split split : splitDetails) {
                    PercentSplit pSplit = (PercentSplit) split; 
                    
                    double share = (expenseAmount * pSplit.getPercentage()) / 100.0;
                    
                    split.setAmount(share);
                }
                expense = new PercentExpense(expenseId, expenseAmount, paidBy, splitDetails);
                break;
                
            default:
                return null;
        }

        if(expense == null || !expense.validate()) {
            return null;
        }

        expenses.add(expense);

        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, splitDetails, expenseAmount);

        return expense;
    }
}