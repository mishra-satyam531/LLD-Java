package ParkingLot;

public class HourlyCostStrategy implements ParkingCostStrategy {
    private static final double PRICE_PER_HOUR = 20.0;

    @Override
    public double calculatePrice(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        long startTime = ticket.getEntryTime();

        long durationInMillis = endTime - startTime;

        double hours = (double) durationInMillis / (1000 * 60 * 60);

        int billableHours = (int) Math.ceil(hours);
        
        if(billableHours == 0) billableHours = 1;

        return billableHours * PRICE_PER_HOUR;
    }
    
}
