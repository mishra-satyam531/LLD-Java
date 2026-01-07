package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Store {
    private int storeId;
    Location storeLocation;
    private VehicleInventoryManagement vehicleInventory;
    private List<Reservation> reservationList;
    
    public Store(int storeId, VehicleInventoryManagement vehicleInventory, List<Reservation> reservationList, Location storeLocation) {
        this.storeId = storeId;
        this.vehicleInventory = vehicleInventory;
        this.reservationList = reservationList;
        this.storeLocation = storeLocation;
    }

    public List<Vehicle> getVehiclesByType(VehicleType type) {
        List<Vehicle> desiredVehicleList = new ArrayList<>();
        Map<Integer, Vehicle> vehicleList = vehicleInventory.getVehicleMap();

        for(Vehicle vehicle : vehicleList.values()) {
            if(vehicle.getVehicleType() == type) {
                desiredVehicleList.add(vehicle);
            }
        }

        return desiredVehicleList;
    }

    public Reservation createReservation(Vehicle vehicle, User user, Date fromDate, Date toDate) {
        if(!vehicleInventory.getVehicleMap().containsKey(vehicle.getId())) {
            System.out.println("Vehicle does not belong to this store");
            return null;
        }

        for(Reservation r : reservationList) {
            if(r.getVehicle().getId() == vehicle.getId()) {
                
                if(r.getStatus() == ReservationStatus.IN_PROGRESS || r.getStatus() == ReservationStatus.SCHEDULED) {
                    
                    if(fromDate.before(r.getDateBookedTo()) && toDate.after(r.getDateBookedFrom())) {
                        System.out.println("Booking Failed: Vehicle is busy during these dates.");
                        return null;
                    }
                }
            }
        }

        Reservation newReservation = new Reservation(user, vehicle, toDate, toDate, toDate, ReservationStatus.SCHEDULED);

        reservationList.add(newReservation);
        System.out.println("Booking Successful for Vehicle: " + vehicle.getVehicleNo());
        return newReservation;
    }

    public int getStoreId() {
        return storeId;
    }

    public VehicleInventoryManagement getVehicleInventory() {
        return vehicleInventory;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public Location getStoreLocation() {
        return storeLocation;
    }
}
