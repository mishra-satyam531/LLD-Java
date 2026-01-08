package CarRentalSystem.service;

import java.util.Map;

import CarRentalSystem.models.Vehicle;

public class VehicleInventoryManagement {
    private Map<Integer, Vehicle> vehicleMap;

    public VehicleInventoryManagement(Map<Integer, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Map<Integer, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleMap.remove(vehicle.getId());
    }
}
