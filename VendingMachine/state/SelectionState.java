package VendingMachine.state;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.model.Coin;
import VendingMachine.model.Item;

public class SelectionState implements VendingMachineState {
    public SelectionState() {
        System.out.println("Machine is in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) {
        try {
            Item item = machine.getInventory().getItem(codeNumber);

            int paidByUser = 0;
            for(Coin coin : machine.getCoinList()) {
                paidByUser += coin.value;
            }

            if(paidByUser < item.getPrice()) {
                System.out.println("Insufficient Amount, Product you selected is for price: " + item.getPrice() + " and you paid: " + paidByUser);

                refundFullMoney(machine);
                return;
            } else {
                if(paidByUser > item.getPrice()) {
                    getChange(paidByUser - item.getPrice());
                }

                machine.setState(new DispenseState());
                machine.getState().dispenseProduct(machine, codeNumber);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            refundFullMoney(machine);
        }
    }

    @Override
    public int getChange(int returnChangeMoney) {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
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
