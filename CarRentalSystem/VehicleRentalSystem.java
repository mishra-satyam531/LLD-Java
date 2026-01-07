package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    private List<Store> storesList;
    private List<User> usersList;

    public VehicleRentalSystem(List<Store> storesList, List<User> usersList) {
        this.storesList = storesList;
        this.usersList = usersList;
    }

    public void addStore(Store newStore) {
        storesList.add(newStore);
    }   

    public void addUser(User newUser) {
        usersList.add(newUser);
    }

    public List<Store> getStore(Location location) {
        List<Store> storesInLocation = new ArrayList<>();

        for(Store store : storesList) {
            if(store.getStoreLocation().equals(location)) {
                storesInLocation.add(store);
            }
        }

        return storesInLocation;
    }
}
