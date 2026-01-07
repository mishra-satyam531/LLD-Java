package ParkingLot.strategies;

import ParkingLot.models.Ticket;

public class FourWheelerCostComputation implements CostComputation {

    @Override
    public int price(Ticket ticket) {
        long entryTime = ticket.getEntryTime();
        long exitTime = System.currentTimeMillis();

        long durationInMillis = exitTime - entryTime;
        
        double minutes = Math.ceil(durationInMillis / (1000.0 * 60.0));

        int hourlyRate = ticket.getSpot().getPrice(); 
        
        double cost = (minutes * hourlyRate) / 60.0;

        if (cost < 5) return 5; 

        return (int) cost;
    }
    
}
