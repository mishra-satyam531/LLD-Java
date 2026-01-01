package ParkingLot2;

public abstract class Vehicle {
    int licenseNumber;
    VehicleType type;

    public Vehicle(int licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public int getLicenseNumber() {
        return this.licenseNumber;
    }

    public VehicleType getVehicleType() {
        return this.type;
    }
}
