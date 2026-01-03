package ParkingLot.models;

public class ParkingSpot {
    private int id;
    private Vehicle vehicle;
    private boolean isEmpty;
    private int price;

    ParkingSpot(int id, int price) {
        this.id = id;
        this.price = price;
        this.isEmpty = true;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public int getId() {
        return this.id;
    }
}
