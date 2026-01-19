package VendingMachine;

import VendingMachine.model.Coin;
import VendingMachine.model.Item;
import VendingMachine.model.ItemType;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine machine = new VendingMachine();
        Item item1 = new Item(ItemType.COKE, 25);
        Item item2 = new Item(ItemType.PEPSI, 20);
        Item item3 = new Item(ItemType.JUICE, 20);
        machine.getInventory().addItem(item1, 101);
        machine.getInventory().addItem(item2, 102);
        machine.getInventory().addItem(item3, 103);

        machine.clickOnInsertCoinButton();
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.DIME);

        machine.clickOnSelectProductButton();
        machine.chooseProduct(101);

        System.out.println("\n--- TEST CASE 2: Insufficient Money ---");
        machine.clickOnInsertCoinButton();
        machine.insertCoin(Coin.DIME);
        machine.clickOnSelectProductButton();
        machine.chooseProduct(102);
    }
}
