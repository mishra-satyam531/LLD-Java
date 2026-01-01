package ParkingLot;

public class MinuteCostStrategy implements ParkingCostStrategy {
    private static final double PRICE_PER_MINUTE = 1.0;

    @Override
    public double calculatePrice(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long startTime = ticket.getEntryTime();

        long durationInMillis = endTime - startTime;

        double minute = (double) durationInMillis / (1000 * 60);

        int billableMinutes = (int) Math.ceil(minute);
        
        if(billableMinutes == 0) billableMinutes = 1;

        return billableMinutes * PRICE_PER_MINUTE;
    }
    
}
