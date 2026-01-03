package ParkingLot.managers;

import java.util.List;

import ParkingLot.models.ParkingSpot;

public class ParkingSpotManager {
    List<ParkingSpot> list;

    public ParkingSpotManager(List<ParkingSpot> list) {
        this.list = list;
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.list.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        this.list.remove(spot);
    }

    public ParkingSpot findParkingSpot() {
        for(ParkingSpot spot : list) {
            if(spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}
