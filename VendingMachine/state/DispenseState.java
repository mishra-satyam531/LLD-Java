package VendingMachine.state;

import java.util.ArrayList;

import VendingMachine.VendingMachine;
import VendingMachine.model.Item;

public class DispenseState implements VendingMachineState {
    private VendingMachine machine;
    private int codeNumber;

    public DispenseState(VendingMachine machine, int codeNumber) {
        System.out.println("Machine is in DispenseState");
        this.machine = machine;
        this.codeNumber = codeNumber;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) {
        System.out.println("You product has been dispensed");

        Item item = null;
        try {
            item = machine.getInventory().getItem(codeNumber);
            
            machine.getInventory().soldOutItem(codeNumber);
            
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }

        machine.setCoinList(new ArrayList<>());
        machine.setState(new IdleState());
        return item;
    }
    
}
