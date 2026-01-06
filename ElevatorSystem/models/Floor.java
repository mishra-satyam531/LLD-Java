package ElevatorSystem.models;

public class Floor {
    int id;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.id = floorNumber;
        externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(id, direction);
    }
}
