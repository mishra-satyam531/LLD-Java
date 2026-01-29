package DesignPattern.creationalPattern.WithStrategyPattern;

import DesignPattern.creationalPattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
