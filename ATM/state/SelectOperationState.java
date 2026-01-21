package ATM.state;

import ATM.models.ATM;
import ATM.models.Card;
import ATM.models.TransactionType;

public class SelectOperationState implements MachineState {

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case BALANCE_CHECK:
                atm.setState(new CheckBalanceState());
                break;
            case CASH_WITHDRAWAL:
                atm.setState(new CashWithdrawalState());
                break;
            default:
                System.out.println("Invalid action");
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
