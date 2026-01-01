package ParkingLot2;

public class Ticket {
    int id;
    long entryTime;
    Vehicle vehicle;
    ParkingSpot spot;

    public Ticket(int id, long entryTime, Vehicle vehicle, ParkingSpot spot) {
        this.id = id;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public long getEntryTime() {
        return this.entryTime;
    }
}
