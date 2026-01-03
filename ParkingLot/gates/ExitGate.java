package ParkingLot.gates;

import ParkingLot.factories.CostComputationFactory;
import ParkingLot.models.Ticket;
import ParkingLot.strategies.CostComputation;

public class ExitGate {
    CostComputationFactory factory;
    public ExitGate(CostComputationFactory factory) {
        this.factory = factory;
    }

    public void priceCalculation(Ticket ticket) {
        CostComputation costComputation = factory.getCostComputation(ticket);

        System.out.println("Total price for parking is: " + costComputation.price(ticket));

        ticket.getSpot().removeVehicle();

        System.out.println("Vehicle Removed. Spot " + ticket.getSpot().getId() + " is now free.");
    }
}
