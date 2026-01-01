package ParkingLot;

import java.util.List;

public class EntryGate {
    ParkingSpotManagerFactory factory;
    List<ParkingSpot> allSpots;

    public EntryGate(ParkingSpotManagerFactory factory, List<ParkingSpot> allSpots) {
        this.factory = factory;
        this.allSpots = allSpots;
    }

    public Ticket bookSpot(Vehicle vehicle) {
        ParkingSpotManager manager = factory.getParkingManager(vehicle, allSpots);
        ParkingSpot spot = manager.findParkingSpace();

        if(spot == null) {
            System.out.println("No spot available for " + vehicle.getType());
            return null;
        }

        manager.parkVehicle(spot, vehicle);

        return generateTicket(vehicle, spot);
    }

    private Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        return new Ticket(123, System.currentTimeMillis(), vehicle, spot);
    }
}
