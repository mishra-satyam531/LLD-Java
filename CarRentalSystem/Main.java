package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Vehicle hondaCity = new Vehicle(1, "DL0345", VehicleType.CAR, Status.ACTIVE, 2022, 5640);

        Map<Integer, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(hondaCity.getId(), hondaCity);

        VehicleInventoryManagement vehicleInventoryManagement = new VehicleInventoryManagement(vehicleMap);

        List<Reservation> reservationList = new ArrayList<>();

        Location storeLocation = new Location();
        storeLocation.address = "A-16";
        storeLocation.pincode = 110043;
        storeLocation.city = "New Delhi";
        storeLocation.state = "Delhi";
        storeLocation.country = "India";

        Store store = new Store(16, vehicleInventoryManagement, reservationList, storeLocation);

        User user = new User();
        user.setId(101);
        user.setName("Satyam");

        Date today = new Date();
        Date dayAfterTomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 2));

        Reservation reservation = store.createReservation(hondaCity, user, today, dayAfterTomorrow);

        if (reservation != null) {
            // 6. Generate Bill
            Bill bill = new Bill(reservation);
            
            // 7. Pay
            PaymentMode payment = new CashPayment();
            payment.makePayment(bill);
        }
    }
}
