package ATM;

import ATM.models.ATM;
import ATM.models.Card;
import ATM.models.TransactionType;
import ATM.models.UserBankAccount;

public class Main {
    public static void main(String[] args) throws Exception {
        ATM atm = new ATM(5, 8, 15, 20);
        UserBankAccount userAccount = new UserBankAccount(50000);
        Card card = new Card(1564, 12345678, 519, 2028, "Satyam", userAccount);

        System.out.println("ATM balance: " + atm.getAtmBalance());

        atm.getState().insertCard(atm, card);
        atm.getState().authenticatePin(atm, card, 1564);
        atm.getState().selectOperation(atm, card, TransactionType.CASH_WITHDRAWAL);
        atm.getState().cashWithdrawal(atm, card, 5000);

        System.out.println("Updated ATM balance: " + atm.getAtmBalance());
    }
}
