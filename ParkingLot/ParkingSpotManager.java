package ParkingLot;

import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> list;

    ParkingSpotManager(List<ParkingSpot> list) {
        this.list = list;
    }

    public ParkingSpot findParkingSpace() {
        for (ParkingSpot spot : list) {
            if (spot.isEmpty) {
                return spot;
            }
        }
        return null;
    }

    public void addParkingSpace(ParkingSpot spot) {
        this.list.add(spot);
    }

    public void removeParkingSpace(ParkingSpot spot) {
        this.list.remove(spot);
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpace();

        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked at spop id: " + spot.id);
        } else {
            System.out.println("No parking space available");
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : list) {
            if(!spot.isEmpty && spot.getVehicle().equals(vehicle)) {
                spot.removeVehicle(vehicle);
                System.out.println("Vehicle unparked from spot: " + spot.id);
                return;
            }
        }

        System.out.println("Vehicle not found in this lot!");
    }
}
