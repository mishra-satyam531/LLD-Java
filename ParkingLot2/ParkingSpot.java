package ParkingLot2;

public class ParkingSpot {
    int id;
    Vehicle vehicle;
    boolean isEmpty;
    int price;

    ParkingSpot(int id,int  price) {
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
}
