package ParkingLot2;

import java.util.List;

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
            if(spot.isEmpty) {
                return spot;
            }
        }
        return null;
    }
}
