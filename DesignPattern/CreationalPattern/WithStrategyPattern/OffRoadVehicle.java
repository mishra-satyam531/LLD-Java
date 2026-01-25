package DesignPattern.CreationalPattern.WithStrategyPattern;

import DesignPattern.CreationalPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
