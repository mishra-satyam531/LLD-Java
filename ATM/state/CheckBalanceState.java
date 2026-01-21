package ATM.state;

import ATM.models.ATM;
import ATM.models.Card;

public class CheckBalanceState implements MachineState {

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Balance in your bank account is: " + card.getBankBalance());
        exit(atm);
    }
    
    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setState(new IdleState());
    }

    @Override
    public void returnCard() {
        System.out.println("Returning card");
    }

}
