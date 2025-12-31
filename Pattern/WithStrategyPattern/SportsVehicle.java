package Pattern.WithStrategyPattern;

import Pattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
