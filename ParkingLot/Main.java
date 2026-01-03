package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.factories.CostComputationFactory;
import ParkingLot.factories.ParkingSpotManagerFactory;
import ParkingLot.gates.EntryGate;
import ParkingLot.gates.ExitGate;
import ParkingLot.models.Bike;
import ParkingLot.models.Car;
import ParkingLot.models.FourWheelerParkingSpot;
import ParkingLot.models.ParkingSpot;
import ParkingLot.models.Ticket;
import ParkingLot.models.TwoWheelerParkingSpot;
import ParkingLot.models.Vehicle;

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
            System.out.println("Bike 101 Parked at Spot: " + bikeTicket.getSpot().getId());
        } else {
            System.out.println("Parking Full. Please wait.");
        }

        Vehicle car = new Car(202);
        Ticket carTicket = entryGate.bookSpot(car);
        if(carTicket != null) {
            System.out.println("Car 202 Parked at Spot: " + carTicket.getSpot().getId());
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
