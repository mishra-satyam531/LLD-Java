package ElevatorSystem.models;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    static {
        ElevatorCar lift1 = new ElevatorCar(1);
        ElevatorController controller1 = new ElevatorController(lift1);

        ElevatorCar lift2 = new ElevatorCar(1);
        ElevatorController controller2 = new ElevatorController(lift2);

        elevatorControllerList.add(controller1);
        elevatorControllerList.add(controller2);
    }
}
