package Splitwise.Expense;

import java.util.List;

import Splitwise.Models.User;
import Splitwise.Split.EqualSplit;
import Splitwise.Split.Split;

public class EqualExpense extends Expense {

    public EqualExpense(String id, double amount, User paidBy, List<Split> splits) {
        super(id, amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()) {
            if(!(split instanceof EqualSplit)) {
                return false;
            }
        }
        
        return getSplits() != null && !getSplits().isEmpty();
    }
    
}
