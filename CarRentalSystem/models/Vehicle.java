package CarRentalSystem.models;

import CarRentalSystem.enums.Status;
import CarRentalSystem.enums.VehicleType;

public class Vehicle {
    private int id;
    private String vehicleNo;
    private VehicleType vehicleType;
    private Status status;
    private int manufacturingDate;
    private int distanceDriveInKM;
    
    public Vehicle(int id, String vehicleNo, VehicleType vehicleType, Status status, int manufacturingDate,
            int distanceDriveInKM) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.status = status;
        this.manufacturingDate = manufacturingDate;
        this.distanceDriveInKM = distanceDriveInKM;
    }

    public int getId() {
        return id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public int getManufacturingDate() {
        return manufacturingDate;
    }

    public int getDistanceDriveInKM() {
        return distanceDriveInKM;
    }
    
}
