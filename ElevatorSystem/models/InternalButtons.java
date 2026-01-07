package ElevatorSystem.models;

import ElevatorSystem.dispatchers.*;

public class InternalButtons {
    InternalDispatcher dispatcher = new InternalDispatcher();

    public void pressButton(int destinationFloor, ElevatorCar elevator) {
        
        dispatcher.submitInternalRequest(destinationFloor, elevator);
    }
}
