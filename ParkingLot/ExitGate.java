package ParkingLot;

import java.util.List;

public class ExitGate {
    ParkingSpotManagerFactory managerFactory;
    List<ParkingSpot> allSpots;
    CostComputationFactory costFactory;

    public ExitGate(ParkingSpotManagerFactory managerFactory, List<ParkingSpot> allSpots, CostComputationFactory costFactory) {
        this.managerFactory = managerFactory;
        this.allSpots = allSpots;
        this.costFactory = costFactory;
    }

    public void processExit(Ticket ticket) {
        ParkingSpotManager manager = managerFactory.getParkingManager(ticket.vehicle, allSpots);
        manager.removeVehicle(ticket.vehicle);

        CostComputation costcomputation = costFactory.getCostComputation(ticket.vehicle);
        double price = costcomputation.price(ticket);
        System.out.println("Exit price is: Rs. " + price);
    }
}
