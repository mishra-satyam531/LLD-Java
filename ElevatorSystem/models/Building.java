package ElevatorSystem.models;

import java.util.List;

public class Building {
    private List<Floor> floorList;

    public Building(List<Floor> floors) {
        this.floorList = floors;
    }

    public void addFloors(Floor newFloor) {
        floorList.add(newFloor);
    }

    public void removeFloors(Floor removeFloor) {
        floorList.remove(removeFloor);
    }

    public List<Floor> getAllFloors() {
        return floorList;
    }
}
