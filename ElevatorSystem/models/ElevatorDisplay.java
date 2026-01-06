package ElevatorSystem.models;

public class ElevatorDisplay {
    int floor;
    Direction direction;

    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
        System.out.println("Display Updated: Floor " + floor + " | Direction " + direction);
    }
    
    public void showDisplay() {
        System.out.println("Current Floor: " + floor);
    }
}
