package DesignPattern.creationalPattern.WithStrategyPattern;

import DesignPattern.creationalPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
