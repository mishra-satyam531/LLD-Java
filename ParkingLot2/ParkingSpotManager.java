package ParkingLot2;

import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> list;

    public ParkingSpotManager(List<ParkingSpot> list) {
        this.list = list;
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.list.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        this.list.remove(spot);
    }

    public ParkingSpot findParkingSpot() {
        for(ParkingSpot spot : list) {
            if(spot.isEmpty) {
                return spot;
            }
        }
        return null;
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpot();

        if(spot == null) {
            System.out.println("No Empty spot");
        } else {
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle is parked at id " + spot.id);
        }
    }
}
