package ParkingLot.gates;

import java.util.List;

import ParkingLot.factories.ParkingSpotManagerFactory;
import ParkingLot.managers.ParkingSpotManager;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.models.Vehicle;

public class EntryGate {
    ParkingSpotManagerFactory factory;
    List<ParkingSpot> allSpots;

    public EntryGate(ParkingSpotManagerFactory factory, List<ParkingSpot> allSpots) {
        this.factory = factory;
        this.allSpots = allSpots;
    }

    public Ticket bookSpot(Vehicle vehicle) {
        ParkingSpotManager manager = factory.getParkingManager(vehicle, allSpots);

        ParkingSpot spot = manager.findParkingSpot();

        if(spot != null) {
            spot.parkVehicle(vehicle);

            return new Ticket((int)(Math.random() * 5), System.currentTimeMillis(), vehicle, spot);
        }
        return null;
    }
}
