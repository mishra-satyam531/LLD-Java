package ParkingLot.models;

public class Ticket {
    private int id;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public Ticket(int id, long entryTime, Vehicle vehicle, ParkingSpot spot) {
        this.id = id;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public long getEntryTime() {
        return this.entryTime;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ParkingSpot getSpot() {
        return this.spot;
    }
}
