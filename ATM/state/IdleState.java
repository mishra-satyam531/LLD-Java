package ATM.state;

import ATM.models.ATM;
import ATM.models.Card;

public class IdleState implements MachineState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setState(new HasCardState());
    }
    
}
