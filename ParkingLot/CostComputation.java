package ParkingLot;

public class CostComputation {
    ParkingCostStrategy strategy;

    public CostComputation(ParkingCostStrategy strategy) {
        this.strategy = strategy;
    }

    public double price(Ticket ticket) {
        return strategy.calculatePrice(ticket);
    }
}
