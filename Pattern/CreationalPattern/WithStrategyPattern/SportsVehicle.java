package Pattern.CreationalPattern.WithStrategyPattern;

import Pattern.CreationalPattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
