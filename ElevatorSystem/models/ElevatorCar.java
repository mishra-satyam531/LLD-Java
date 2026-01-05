package ElevatorSystem.models;

import java.util.TreeSet;

public class ElevatorCar {
    private int id;
    int currentFloor;
    Direction direction;
    ElevatorState state;
    TreeSet<Integer> upStops;
    TreeSet<Integer> downStops;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.UP;
        this.state = ElevatorState.IDLE;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>();
    }

    public void addStop(int floor) {
        if(floor == currentFloor) return;

        if(floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }

        if(this.state == ElevatorState.IDLE) {
            this.state = ElevatorState.MOVING;

            if(floor > currentFloor) {
                this.direction = Direction.UP;
            } else {
                this.direction = Direction.DOWN;
            }
        }
    }

    public void move() {
        if(upStops.isEmpty() && downStops.isEmpty()) {
            this.state = ElevatorState.IDLE;
            return;
        }

        if(this.direction == Direction.UP) {
            if(!upStops.isEmpty()) {
                int nextFloor = upStops.pollFirst();
                this.currentFloor = nextFloor;
                System.out.println("Moving UP to floor: " + currentFloor);
            } else {
                this.direction = Direction.DOWN;
            }
        } else if(this.direction == Direction.DOWN) {
            if(!downStops.isEmpty()) {
                int nextFloor = downStops.pollLast();
                this.currentFloor = nextFloor;
                System.out.println("Moving DOWN to floor: " + currentFloor);
            } else {
                this.direction = Direction.UP;
            }
        }
    }

    public int getId() {
        return this.id;
    }
}
