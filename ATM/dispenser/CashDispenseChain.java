package ATM.dispenser;

import ATM.models.ATM;

public abstract class CashDispenseChain {
    CashDispenseChain nextDispenser;

    public CashDispenseChain(CashDispenseChain nextDispenser) {
        this.nextDispenser = nextDispenser;
    }
    
    public void dispense(ATM atm, int amount) {
        if(nextDispenser != null) {
            this.nextDispenser.dispense(atm, amount);
        }
    }
}
