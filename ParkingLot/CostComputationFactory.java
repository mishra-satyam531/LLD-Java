package ParkingLot;

public class CostComputationFactory {
    public CostComputation getCostComputation(Vehicle vehicle) {
        VehicleType type = vehicle.getType();

        if(type == VehicleType.BIKE) {
            return new TwoWheelerCostComputation();
        } else if(type == VehicleType.CAR) {
            return new FourWheelerCostComputation();
        } else return null;
    }
}
