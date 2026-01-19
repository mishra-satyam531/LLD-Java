package VendingMachine.state;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.model.Coin;

public class HasMoneyState implements VendingMachineState {
    public HasMoneyState() {
        System.out.println("Machine is in HasMoneyState");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) {
        machine.setState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");

        List<Coin> refund = machine.getCoinList();
        machine.setCoinList(new ArrayList<>());
        machine.setState(new IdleState());

        return refund;
    }

    
}
