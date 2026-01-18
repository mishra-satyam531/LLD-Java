package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingMachineState state;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        this.state = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public void clickOnInsertCoinButton() {
        state.clickOnInsertCoinButton(this);
    }

    public void clickOnSelectProductButton() {
        state.clickOnSelectProductButton(this);
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void chooseProduct(int codeNumber) {
        state.chooseProduct(this, codeNumber);
    }

    public void addCoin(Coin coin) {
        this.coinList.add(coin);
    }
}
