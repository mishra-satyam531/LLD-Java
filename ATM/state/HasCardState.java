package ATM.state;

import ATM.models.ATM;
import ATM.models.Card;

public class HasCardState implements MachineState {

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) throws Exception {
        if(card.isCorrectPINEntered(pin)) {
            System.out.println("PIN entered is correct");
            atm.setState(new SelectOperationState());
        } else {
            throw new Exception("PIN entered is incorrect");
        }
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
