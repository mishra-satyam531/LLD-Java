package ParkingLot.strategies;

import ParkingLot.models.Ticket;

public interface CostComputation {
    int price(Ticket ticket);
}
