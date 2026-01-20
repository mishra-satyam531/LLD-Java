package ATM.models;

public class Card {
    private int pinNumber;
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    private UserBankAccount bankAccount;

    public Card(int pinNumber, int cardNumber, int cvv, int expiryDate, String holderName, UserBankAccount bankAccount) {
        this.pinNumber = pinNumber;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.holderName = holderName;
        this.bankAccount = bankAccount;
    }

    public boolean isCorrectPINEntered(int pin) {
        return pin == this.pinNumber;
    }

    public int getBankBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount) throws Exception {
        bankAccount.deductBalance(amount);
    }

    public int getpinNumber() {
        return pinNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public String getHolderName() {
        return holderName;
    }

    public UserBankAccount getBankAccount() {
        return bankAccount;
    }

}
