package ParkingLot.factories;

import ParkingLot.models.Ticket;
import ParkingLot.models.VehicleType;
import ParkingLot.strategies.CostComputation;
import ParkingLot.strategies.FourWheelerCostComputation;
import ParkingLot.strategies.TwoWheelerCostComputation;

public class CostComputationFactory {
    public CostComputation getCostComputation(Ticket ticket) {
        VehicleType type = ticket.getVehicle().getVehicleType();

        if(type == VehicleType.BIKE) {
            return new TwoWheelerCostComputation();
        } else if(type == VehicleType.CAR) {
            return new FourWheelerCostComputation();
        }

        return null;
    }
}
