package ElevatorSystem.controllers;

import ElevatorSystem.enums.*;
import ElevatorSystem.models.*;

public class ElevatorController {
    public ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public void submitExternalRequest(int floor, Direction direction) {
        elevatorCar.addStop(floor);
        System.out.println("Lift " + elevatorCar.getId() + " accepted request for Floor " + floor);
    }

    public void submitInternalRequest(int floor) {
        elevatorCar.addStop(floor);
    }

    public int calculateCost(int floor, Direction direction) {
        int distance = Math.abs(floor - elevatorCar.getCurrentFloor());

        // Case 1: Same direction
        if(elevatorCar.state == ElevatorState.MOVING && elevatorCar.getDirection() == direction && isRequestOnPath(floor, direction)) {
            return distance;
        }

        // Case 2 : Elevator is IDLE
        if(elevatorCar.state == ElevatorState.IDLE) {
            return distance;
        }

        // CASE 3 : Moving away
        // return distance + 5000; // added penalty, this approach might work in interviews but is not necessarily correct, real logic is below
        if(elevatorCar.getDirection() == Direction.DOWN) { // target was up
            return elevatorCar.getCurrentFloor() + floor;
        } else { // target is down
            int topFloor = 10; // hardcoded for now
            return (topFloor - elevatorCar.getCurrentFloor()) + (topFloor - floor);
        }
    }

    private boolean isRequestOnPath(int floor, Direction direction) {
        if(direction == Direction.UP) {
            return floor >= elevatorCar.getCurrentFloor();
        } else {
            return floor <= elevatorCar.getCurrentFloor();
        }
    }

}
