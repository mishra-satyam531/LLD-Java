package ParkingLot2;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager getParkingManager(Vehicle vehicle, List<ParkingSpot> allSpots) {
        VehicleType type = vehicle.getVehicleType();

        if(type == VehicleType.BIKE) {
            List<ParkingSpot> bikeSpots = new ArrayList<>();
            for(ParkingSpot spot : allSpots) {
                if (spot instanceof TwoWheelerParkingSpot) {
                    bikeSpots.add(spot);
                }
            }
            return new ParkingSpotManager(bikeSpots);
        } else if(type == VehicleType.CAR) {
            List<ParkingSpot>carSpots = new ArrayList<>();
            for(ParkingSpot spot : allSpots) {
                if (spot instanceof FourWheelerParkingSpot) {
                    carSpots.add(spot);
                }
            }
            return new ParkingSpotManager(carSpots);
        } else {
            return null;
        }
    }
}
