package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ==========================================
        // 1. INFRASTRUCTURE SETUP (Parking Lot banana)
        // ==========================================
        
        List<ParkingSpot> spots = new ArrayList<>();
        
        // Maan lo humare paas 5 spots hain
        // Spots 1-3: Two Wheelers (Price 10)
        for (int i = 1; i <= 3; i++) {
            spots.add(new TwoWheeler(i));
        }
        // Spots 4-5: Four Wheelers (Price 20)
        for (int i = 4; i <= 5; i++) {
            spots.add(new FourWheeler(i));
        }

        // Factories initialize karo
        ParkingSpotManagerFactory managerFactory = new ParkingSpotManagerFactory();
        CostComputationFactory costFactory = new CostComputationFactory();

        // Gates open karo
        EntryGate entryGate = new EntryGate(managerFactory, spots);
        ExitGate exitGate = new ExitGate(managerFactory, spots, costFactory);

        System.out.println("🅿️ Parking Lot is Open!\n");

        // ==========================================
        // 2. ENTRY SCENARIO
        // ==========================================

        // --- Scene 1: Ek Car aayi (Plate 2001) ---
        Vehicle car = new Car(2001);
        System.out.println("🚗 Car 2001 reached Entry Gate...");
        
        Ticket carTicket = entryGate.bookSpot(car);
        if (carTicket != null) {
            System.out.println(" Ticket Generated. Entry Time: " + carTicket.getEntryTime());
        }

        System.out.println("---------------------------------");

        // --- Scene 2: Ek Bike aayi (Plate 9999) ---
        Vehicle bike = new Bike(9999);
        System.out.println("🏍️ Bike 9999 reached Entry Gate...");
        
        Ticket bikeTicket = entryGate.bookSpot(bike);
        if (bikeTicket != null) {
            System.out.println("   ✅ Ticket Generated. Entry Time: " + bikeTicket.getEntryTime());
        }

        System.out.println("---------------------------------");

        // ==========================================
        // 3. TIME SIMULATION (Shopping Time) 🕒
        // ==========================================
        System.out.println("...Vehicles are parked. Time is passing (3 seconds)...");
        Thread.sleep(3000); // Program ko 3 second ke liye roko
        System.out.println("---------------------------------");

        // ==========================================
        // 4. EXIT SCENARIO
        // ==========================================

        // --- Scene 3: Car wapas ja rahi hai ---
        // Recall: Car use karti hai 'MinuteStrategy' (Rs 1 per min)
        // Note: Code mein 3 sec ~ 0.05 mins -> Ceil -> 1 min charge hoga
        System.out.println("Car 2001 reached Exit Gate...");
        exitGate.processExit(carTicket);

        System.out.println("---------------------------------");

        // --- Scene 4: Bike wapas ja rahi hai ---
        // Recall: Bike use karti hai 'HourlyStrategy' (Rs 20 per hour)
        // Note: 3 sec ~ 0 hours -> Ceil -> 1 hour charge hoga
        System.out.println("🏍️ Bike 9999 reached Exit Gate...");
        exitGate.processExit(bikeTicket);
    }
}