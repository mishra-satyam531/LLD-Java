package ParkingLot;

public class FourWheelerCostComputation extends CostComputation {
    
    public FourWheelerCostComputation() {
        super(new MinuteCostStrategy());
    }

}
