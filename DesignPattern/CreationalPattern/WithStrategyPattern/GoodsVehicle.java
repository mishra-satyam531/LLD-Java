package DesignPattern.CreationalPattern.WithStrategyPattern;

import DesignPattern.CreationalPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
