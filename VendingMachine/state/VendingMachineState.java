package VendingMachine.state;

import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.model.Coin;
import VendingMachine.model.Item;

public interface VendingMachineState {
    default public void clickOnInsertCoinButton(VendingMachine machine) {
        System.out.println("You cannot insert a coin right now");
    }

    default public void clickOnSelectProductButton(VendingMachine machine) {
        System.out.println("You cannot select a product right now");
    }

    default public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("You cannot insert coin right now");
    }

    default public void chooseProduct(VendingMachine machine, int codeNumber) {
        System.out.println("You cannot choose product right now");
    }

    default public int getChange(int returnChangeMoney) {
        return 0;
    }

    default public Item dispenseProduct(VendingMachine machine, int codeNumber) {
        System.out.println("You cannot dispense product now");
        return null;
    }

    default public List<Coin> refundFullMoney(VendingMachine machine) {
        return null;
    }

    default public void updateInventory(VendingMachine machine, Item item, int codeNumber) {
        
    }
}
