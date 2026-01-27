package Splitwise;

import java.util.ArrayList;
import java.util.List;

import Splitwise.Enums.ExpenseType;
import Splitwise.Split.EqualSplit;
import Splitwise.Split.Split;
import Splitwise.Split.User;

public class Splitwise {
    private UserController userController;
    private GroupController groupController;
    private BalanceSheetController balanceSheetController;
    private ExpenseController expenseController;

    public Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
        expenseController = new ExpenseController(balanceSheetController);
    }

    public void demo() {
        setupUserAndGroup();

        User user1 = userController.getUser("U2001");
        User user2 = userController.getUser("U2002");

        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U2002"));

        List<Split> splits = new ArrayList<>();
        splits.add(new EqualSplit(user1)); 
        splits.add(new EqualSplit(user2));
        
        expenseController.createExpense("Exp1", "Lunch", 300, splits, ExpenseType.EQUAL, user1);

        for(User user : userController.getAllUsers()) {
            balanceSheetController.showBalance(user.getUserExpenseBalanceSheet());
        }
    }

    public void setupUserAndGroup() {
        addUsersToSystem();
        User user1 = userController.getUser("U2001");
        groupController.createGroup("G1001", "Goa Trip", user1);
    }

    private void addUsersToSystem() {
        userController.addUser(new User("User1", "U2001")); 
        userController.addUser(new User("User2", "U2002"));
        userController.addUser(new User("User3", "U2003"));
    }
}
