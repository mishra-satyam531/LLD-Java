package ParkingLot;

import java.util.List;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager getParkingManager(Vehicle vehicle, List<ParkingSpot> allSpots) {
        VehicleType type = vehicle.getType();

        if(type == VehicleType.BIKE) {
            return new TwoWheelerManager(allSpots);
        } else if(type == VehicleType.CAR) {
            return new FourWheelerManager(allSpots);
        } else return null;
    }
}
