package ElevatorSystem.dispatchers;

import java.util.List;

import ElevatorSystem.models.*;
import ElevatorSystem.controllers.*;
import ElevatorSystem.registry.*;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {
        
        for(ElevatorController controller : elevatorControllerList) {
            
            if(controller.elevatorCar.getId() == elevatorCar.getId()) {
                
                controller.submitInternalRequest(floor);
                break;
            }
        }
    }
}
