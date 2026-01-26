package Splitwise.Expense;

import java.util.List;

import Splitwise.Split.PercentSplit;
import Splitwise.Split.Split;
import Splitwise.Split.User;

public class PercentExpense extends Expense {

    public PercentExpense(String id, double amount, User paidBy, List<Split> splits) {
        super(id, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalPercentage = 0;
        for(Split split : getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            totalPercentage += percentSplit.getPercentage();
        }

        return totalPercentage == 100.0;
    }
    
}
