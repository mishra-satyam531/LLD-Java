package ParkingLot;

public class TwoWheelerCostComputation extends CostComputation {

    public TwoWheelerCostComputation() {
        super(new HourlyCostStrategy());
    }
    
}
