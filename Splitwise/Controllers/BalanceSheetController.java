package Splitwise.Controllers;

import java.util.List;
import java.util.Map;

import Splitwise.Models.Balance;
import Splitwise.Models.User;
import Splitwise.Models.UserExpenseBalanceSheet;
import Splitwise.Split.Split;

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
