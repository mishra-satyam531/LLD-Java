package ElevatorSystem.models;

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
        int distance = Math.abs(floor - elevatorCar.currentFloor);

        // Case 1: Same direction
        if(elevatorCar.state == ElevatorState.MOVING && elevatorCar.direction == direction && isRequestOnPath(floor, direction)) {
            return distance;
        }

        // Case 2 : Elevator is IDLE
        if(elevatorCar.state == ElevatorState.IDLE) {
            return distance;
        }

        // CASE 3 : Moving away
        // return distance + 5000; // added penalty, this approach might work in interviews but is not necessarily correct, real logic is below
        if(elevatorCar.direction == Direction.DOWN) { // target was up
            return elevatorCar.currentFloor + floor;
        } else { // target is down
            int topFloor = 10; // hardcoded for now
            return (topFloor - elevatorCar.currentFloor) + (topFloor - floor);
        }
    }

    private boolean isRequestOnPath(int floor, Direction direction) {
        if(direction == Direction.UP) {
            return floor >= elevatorCar.currentFloor;
        } else {
            return floor <= elevatorCar.currentFloor;
        }
    }

}
