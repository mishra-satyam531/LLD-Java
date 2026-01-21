package ATM.state;

import ATM.dispenser.CashDispenseChain;
import ATM.dispenser.TwoThousandNoteDispenser;
import ATM.dispenser.FiveHundredNoteDispenser;
import ATM.dispenser.TwoHundredNoteDispenser;
import ATM.dispenser.OneHundredNoteDispenser;
import ATM.models.ATM;
import ATM.models.Card;

public class CashWithdrawalState implements MachineState {
    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) throws Exception {
        if(atm.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient cash in the ATM");
            exit(atm);
            return;
        } 
        else if(card.getBankBalance() < withdrawAmount) {
            System.out.println("Insufficient cash in the bank account");
            exit(atm);
            return;
        }

        card.deductBankBalance(withdrawAmount);
        CashDispenseChain chain = new TwoThousandNoteDispenser(new FiveHundredNoteDispenser(new TwoHundredNoteDispenser(new OneHundredNoteDispenser(null))));
        chain.dispense(atm, withdrawAmount);
        System.out.println("Please collect your cash");
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
