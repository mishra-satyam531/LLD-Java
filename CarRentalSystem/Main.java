package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

import CarRentalSystem.enums.Status;
import CarRentalSystem.enums.VehicleType;
import CarRentalSystem.models.Bill;
import CarRentalSystem.models.Location;
import CarRentalSystem.models.Reservation;
import CarRentalSystem.models.Store;
import CarRentalSystem.models.User;
import CarRentalSystem.models.Vehicle;
import CarRentalSystem.payment.CashPayment;
import CarRentalSystem.payment.PaymentMode;
import CarRentalSystem.service.VehicleInventoryManagement;
import CarRentalSystem.service.VehicleRentalSystem;

public class Main {
    public static void main(String[] args) {
        Vehicle hondaCity = new Vehicle(1, "DL03-AB-1234", VehicleType.CAR, Status.ACTIVE, 2022, 5000);
        Vehicle hyundaiCreta = new Vehicle(2, "UP16-X-9999", VehicleType.CAR, Status.ACTIVE, 2023, 2000);

        Map<Integer, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put(hondaCity.getId(), hondaCity);
        vehicleMap.put(hyundaiCreta.getId(), hyundaiCreta);

        VehicleInventoryManagement inventoryManagement = new VehicleInventoryManagement(vehicleMap);

        Location location = new Location("Sector 62", 201309, "Noida", "UP", "India");

        List<Reservation> storReservations = new ArrayList<>();
        Store store = new Store(101, inventoryManagement, storReservations, location);
        
        List<Store> stores = new ArrayList<>();
        stores.add(store);
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, new ArrayList<>());

        System.out.println(">> System Setup Complete. Store is Open!");

        User user = new User();
        user.setUserId(1);
        user.setUserName("Satyam Mishra");
        user.setDrivingLicense("DL-2025-XYZ");

        List<Vehicle> availableCars = store.getVehiclesByType(VehicleType.CAR);
        System.out.println("\n>> Found " + availableCars.size() + " cars at the store.");

        Vehicle selectedVehicle = availableCars.get(0); // User chooses the first one

        Date today = new Date();
        Date threeDaysLater = new Date(today.getTime() + (3L * 24 * 60 * 60 * 1000));

        System.out.println(">> Attempting to book vehicle: " + selectedVehicle.getVehicleNo());
        Reservation reservation = store.createReservation(selectedVehicle, user, today, threeDaysLater);

        if (reservation != null) {
            System.out.println(">> Booking Success! Reservation ID: " + reservation.getReservationId());
            
            Bill bill = new Bill(reservation);
            System.out.println(">> Bill Generated. Amount to pay: Rs. " + bill.getAmount());
            
            PaymentMode paymentMode = new CashPayment();
            paymentMode.makePayment(bill);
            
            System.out.println(">> Transaction Complete. Enjoy your ride!");
        } else {
            System.out.println(">> Booking Failed. Vehicle not available.");
        }
    }
}
