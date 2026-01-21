package ATM.state;

import ATM.models.ATM;
import ATM.models.Card;
import ATM.models.TransactionType;

public interface MachineState {
    default public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    default public void authenticatePin(ATM atm, Card card, int pin) throws Exception {
        System.out.println("OOPS!! Something went wrong");
    }

    default public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("OOPS!! Something went wrong");
    }
    
    default public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {
        System.out.println("OOPS!! Something went wrong");
    }
    
    default public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    default public void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    default public void exit(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}
