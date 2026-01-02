package ParkingLot2;

public class ExitGate {
    CostComputationFactory factory;
    public ExitGate(CostComputationFactory factory) {
        this.factory = factory;
    }

    public void priceCalculation(Ticket ticket) {
        CostComputation costComputation = factory.getCostComputation(ticket);

        System.out.println("Total price for parking is: " + costComputation.price(ticket));

        ticket.spot.removeVehicle(ticket.vehicle);

        System.out.println("Vehicle Removed. Spot " + ticket.spot.id + " is now free.");
    }
}
