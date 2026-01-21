package ATM.dispenser;

import ATM.models.ATM;

public class FiveHundredNoteDispenser extends CashDispenseChain {

    public FiveHundredNoteDispenser(CashDispenseChain nextDispenser) {
        super(nextDispenser);
    }

    public void dispense(ATM atm, int remainingAmount) {
        int requiredCount = remainingAmount / 500;
        int availableCount = atm.getNumOfFiveHundredNotes();
        int actualCount = Math.min(availableCount, requiredCount);

        atm.setNumOfFiveHundredNotes(availableCount - actualCount);
        
        remainingAmount -= 500 * actualCount;
        if(remainingAmount > 0) {
            super.dispense(atm, remainingAmount);
        }
    }
    
}
