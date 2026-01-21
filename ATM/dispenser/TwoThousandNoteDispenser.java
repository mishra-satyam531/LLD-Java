package ATM.dispenser;

import ATM.models.ATM;

public class TwoThousandNoteDispenser extends CashDispenseChain {

    public TwoThousandNoteDispenser(CashDispenseChain nextDispenser) {
        super(nextDispenser);
    }

    public void dispense(ATM atm, int remainingAmount) {
        int requiredCount = remainingAmount / 2000;
        int availableCount = atm.getNumOfTwoThousandNotes();
        int actualCount = Math.min(availableCount, requiredCount);

        atm.setNumOfTwoThousandNotes(availableCount - actualCount);
        
        remainingAmount -= 2000 * actualCount;
        if(remainingAmount > 0) {
            super.dispense(atm, remainingAmount);
        }
    }
    
}
