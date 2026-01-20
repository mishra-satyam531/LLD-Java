package ATM.models;

public class UserBankAccount {
    private int balance;

    public UserBankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deductBalance(int amount) throws Exception {
        if(amount <= balance) {
            balance -= amount;
        } else {
            throw new Exception("Insufficient balance");
        }
    }

}
