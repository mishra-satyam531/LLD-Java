package ParkingLot2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<ParkingSpot> spots = new ArrayList<>();
        
        for(int i=1; i<=3; i++) {
            spots.add(new TwoWheelerParkingSpot(i));
        }
        
        for(int i=4; i<=6; i++) {
            spots.add(new FourWheelerParkingSpot(i));
        }

        ParkingSpotManagerFactory managerFactory = new ParkingSpotManagerFactory();
        CostComputationFactory costFactory = new CostComputationFactory();

        EntryGate entryGate = new EntryGate(managerFactory, spots);
        ExitGate exitGate = new ExitGate(costFactory);

        Vehicle bike = new Bike(101);
        Ticket bikeTicket = entryGate.bookSpot(bike);
        if(bikeTicket != null) {
            System.out.println("Bike 101 Parked at Spot: " + bikeTicket.spot.id);
        }

        Vehicle car = new Car(202);
        Ticket carTicket = entryGate.bookSpot(car);
        if(carTicket != null) {
            System.out.println("Car 202 Parked at Spot: " + carTicket.spot.id);
        }

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Exiting ---");
        
        if (bikeTicket != null) {
            exitGate.priceCalculation(bikeTicket);
        }
        
        if (carTicket != null) {
            exitGate.priceCalculation(carTicket);
        }
    }
}
