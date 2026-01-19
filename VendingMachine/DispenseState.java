package VendingMachine;

public class DispenseState implements VendingMachineState {
    private VendingMachine machine;
    private int codeNumber;

    public DispenseState(VendingMachine machine, int codeNumber) {
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
        machine.setState(new IdleState());
        return item;
    }
    
}
