package ParkingLot;

public abstract class Vehicle {
    protected int licensePlate;
    protected VehicleType type;

    public Vehicle(int licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return this.type;
    }

    public int getLicensePlate() {
        return this.licensePlate;
    }
}
