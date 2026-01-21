package ATM.dispenser;

import ATM.models.ATM;

public class OneHundredNoteDispenser extends CashDispenseChain {

    public OneHundredNoteDispenser(CashDispenseChain nextDispenser) {
        super(nextDispenser);
    }

    public void dispense(ATM atm, int remainingAmount) {
        int requiredCount = remainingAmount / 100;
        int availableCount = atm.getNumOfOneHundredNotes();
        int actualCount = Math.min(availableCount, requiredCount);

        atm.setNumOfOneHundredNotes(availableCount - actualCount);
        
        remainingAmount -= 100 * actualCount;
        if(remainingAmount > 0) {
            super.dispense(atm, remainingAmount);
        }
    }
    
}
