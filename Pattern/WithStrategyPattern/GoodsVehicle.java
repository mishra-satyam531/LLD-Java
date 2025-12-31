package Pattern.WithStrategyPattern;

import Pattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
