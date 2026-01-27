package Splitwise.Models;

public class User {
    private String userName;
    private String userId;
    private UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    public void setUserExpenseBalanceSheet(UserExpenseBalanceSheet userExpenseBalanceSheet) {
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }

}
