package ParkingLot;

public abstract class ParkingSpot {
    int id;
    boolean isEmpty;
    Vehicle vehicle;
    int price;

    public ParkingSpot(int id, int price) {
        this.id = id;
        this.price = price;
        this.isEmpty = true;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = true;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
