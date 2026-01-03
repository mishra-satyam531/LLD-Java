package ParkingLot.models;

public class Car extends Vehicle{
    public Car(int licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
