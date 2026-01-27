package Splitwise.Models;

import java.util.ArrayList;
import java.util.List;

import Splitwise.Expense.Expense;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> members;
    private List<Expense> expenseList;
    
    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.expenseList = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }
}
