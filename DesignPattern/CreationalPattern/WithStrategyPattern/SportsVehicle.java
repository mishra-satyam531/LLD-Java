package DesignPattern.CreationalPattern.WithStrategyPattern;

import DesignPattern.CreationalPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
