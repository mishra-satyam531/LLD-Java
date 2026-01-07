package ElevatorSystem.dispatchers;

import java.util.List;

import ElevatorSystem.controllers.*;
import ElevatorSystem.registry.*;
import ElevatorSystem.enums.*;

public class ExternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction) {
        ElevatorController optimalElevatorController = null;
        int minCost = Integer.MAX_VALUE;

        for(ElevatorController elevatorController : elevatorControllerList) {
            int cost = elevatorController.calculateCost(floor, direction);

            if(cost < minCost) {
                optimalElevatorController = elevatorController;
                minCost = cost;
            }
        }

        if(optimalElevatorController != null) {
            // Yahan hum specifically "Winner" controller ko request bhej rahe hain
            optimalElevatorController.submitExternalRequest(floor, direction);
        }
    }
}
