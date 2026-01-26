package Splitwise.Split;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userName;
    private String userId;
    private Map<String, Double> balances;
    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        balances = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public Map<String, Double> getBalances() {
        return balances;
    }

    public void setBalances(String userId, double amount) {
        balances.put(userId, amount);
    }
    
}
