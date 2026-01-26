package Splitwise.Expense;

import java.util.List;

import Splitwise.Split.ExactSplit;
import Splitwise.Split.Split;
import Splitwise.Split.User;

public class ExactExpense extends Expense {

    public ExactExpense(String id, double amount, User paidBy, List<Split> splits) {
        super(id, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double sumSplitAmount = 0;

        for(Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        return totalAmount == sumSplitAmount;
    }

}
