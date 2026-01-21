package ATM.dispenser;

import ATM.models.ATM;

public class TwoHundredNoteDispenser extends CashDispenseChain {

    public TwoHundredNoteDispenser(CashDispenseChain nextDispenser) {
        super(nextDispenser);
    }

    public void dispense(ATM atm, int remainingAmount) {
        int requiredCount = remainingAmount / 200;
        int availableCount = atm.getNumOfTwoHundredNotes();
        int actualCount = Math.min(availableCount, requiredCount);

        atm.setNumOfTwoHundredNotes(availableCount - actualCount);
        
        remainingAmount -= 200 * actualCount;
        if(remainingAmount > 0) {
            super.dispense(atm, remainingAmount);
        }
    }
    
}
