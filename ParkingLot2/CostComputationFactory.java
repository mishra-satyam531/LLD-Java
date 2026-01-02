package ParkingLot2;

public class CostComputationFactory {
    public CostComputation getCostComputation(Ticket ticket) {
        VehicleType type = ticket.vehicle.type;

        if(type == VehicleType.BIKE) {
            return new TwoWheelerCostComputation();
        } else if(type == VehicleType.CAR) {
            return new FourWheelerCostComputation();
        }

        return null;
    }
}
