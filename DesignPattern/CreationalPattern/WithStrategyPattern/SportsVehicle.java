package DesignPattern.creationalPattern.WithStrategyPattern;

import DesignPattern.creationalPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
