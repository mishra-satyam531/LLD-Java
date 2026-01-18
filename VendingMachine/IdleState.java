package VendingMachine;

public class IdleState implements VendingMachineState {
    public IdleState() {
        System.out.println("Machine is in IdleState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        machine.setState(new HasMoneyState());
    }

}
