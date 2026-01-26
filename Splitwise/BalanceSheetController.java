package Splitwise;

import java.util.List;
import java.util.Map;

import Splitwise.Split.Split;
import Splitwise.Split.User;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        
        for (Split split : splits) {
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();
            double amountOwe = split.getAmount();

            if (expensePaidBy.getUserId().equals(userOwe.getUserId())) {
                continue;
            }

            updateBalanceHelper(paidByUserExpenseSheet, userOwe.getUserId(), amountOwe);

            updateBalanceHelper(oweUserExpenseSheet, expensePaidBy.getUserId(), -amountOwe);
        }
    }

    private void updateBalanceHelper(UserExpenseBalanceSheet sheet, String friendId, double amount) {
        Map<String, Balance> balances = sheet.getUserVsBalance();
        
        if (!balances.containsKey(friendId)) {
            balances.put(friendId, new Balance());
        }
        
        Balance balance = balances.get(friendId);
        
        balance.setAmount(balance.getAmount() + amount);

        if (balance.getAmount() > 0) {
            balance.setAmountGetBack(balance.getAmount());
            balance.setAmountOwe(0);
        } else {
            balance.setAmountOwe(Math.abs(balance.getAmount()));
            balance.setAmountGetBack(0);
        }
    }

    public void showBalance(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showBalance'");
    }
}
