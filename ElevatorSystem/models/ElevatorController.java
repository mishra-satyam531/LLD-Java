package ElevatorSystem.models;

import java.util.List;

public class ElevatorController {
    private List<ElevatorCar> elevatorList;

    public ElevatorController(List<ElevatorCar> elevatorList) {
        this.elevatorList = elevatorList;
    }

    public void submitExternalRequest(int floor, Direction direction) {
        ElevatorCar optimalElevatorCar = null;
        int minCost = Integer.MAX_VALUE;

        for(ElevatorCar elevator : elevatorList) {
            int cost = calculateCost(elevator, floor, direction);

            if(cost < minCost) {
                optimalElevatorCar = elevator;
                minCost = cost;
            }
        }

        if(optimalElevatorCar != null) {
            System.out.println("Request assigned to elevator id: " + optimalElevatorCar.getId());
            optimalElevatorCar.addStop(floor);
        }
    }

    private int calculateCost(ElevatorCar elevator, int floor, Direction direction) {
        int distance = Math.abs(floor - elevator.currentFloor);

        // Case 1: Same direction
        if(elevator.state == ElevatorState.MOVING && elevator.direction == direction && isRequestOnPath(elevator, floor, direction)) {
            return distance;
        }

        // Case 2 : Elevator is IDLE
        if(elevator.state == ElevatorState.IDLE) {
            return distance;
        }

        // CASE 3 : Moving away
        // return distance + 5000; // added penalty, this approach might work in interviews but is not necessarily correct, real logic is down

        if(elevator.direction == Direction.DOWN) { // target was up
            return elevator.currentFloor + floor;
        } else { // target is down
            int topFloor = 10; // hardcoded for now
            return (topFloor - elevator.currentFloor) + (topFloor - floor);
        }
    }

    private boolean isRequestOnPath(ElevatorCar elevator, int floor, Direction direction) {
        if(direction == Direction.UP) {
            return floor >= elevator.currentFloor;
        } else {
            return floor <= elevator.currentFloor;
        }
    }

    public void submitInternalRequest(int floor, ElevatorCar elevator) {
        elevator.addStop(floor);
        System.out.println("Internal Request processed for Elevator " + elevator.getId() + " to go to floor " + floor);
    }
}
