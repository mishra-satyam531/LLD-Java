package ParkingLot2;

public class TwoWheelerCostComputation implements CostComputation {

    @Override
    public int price(Ticket ticket) {
        long entryTime = ticket.getEntryTime();
        long exitTime = System.currentTimeMillis();

        long durationInMillis = exitTime - entryTime;
        double hours = (double)durationInMillis / (1000 * 60 * 60);
        if (hours < 1) {
            hours = 1;
        } else {
            hours = Math.ceil(hours);
        }

        int cost = (int)(hours * ticket.spot.price);
        return cost;
    }
    
}
