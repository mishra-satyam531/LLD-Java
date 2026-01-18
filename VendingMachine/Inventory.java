package VendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;
    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf(startCode, null, true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory)  {
            if(itemShelf.code == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                    return;
                } else {
                    throw new Exception("Item is already present");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    throw new Exception("Item is already sold out");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid code");
    }

    public void soldOutItem(int codeNumber) {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
