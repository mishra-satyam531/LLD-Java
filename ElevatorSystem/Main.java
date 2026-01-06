package ElevatorSystem;

import ElevatorSystem.enums.Direction;
import ElevatorSystem.enums.ElevatorState;
import ElevatorSystem.models.*;
import ElevatorSystem.registry.ElevatorCreator;
import ElevatorSystem.controllers.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> floorList = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {
            floorList.add(new Floor(i));
        }
        Building building = new Building(floorList);

        System.out.println("--------------------------------------------");
        System.out.println("Building Initialized with 10 Floors");
        System.out.println("2 Lifts Created by ElevatorCreator");
        System.out.println("--------------------------------------------");

        // Step 1: User is at Floor 0 and presses the UP button
        System.out.println("\n[USER ACTION] Pressing UP button at Floor 0");
        Floor floor0 = floorList.get(0);
        floor0.pressButton(Direction.UP);

        // Step 2: Assume Lift 1 (ID: 1) arrives. User enters.
        // User presses internal button '5'.
        System.out.println("\n[USER ACTION] User enters Lift 1 & presses 5");

        ElevatorController controller1 = ElevatorCreator.elevatorControllerList.get(0);
        ElevatorCar lift1 = controller1.elevatorCar;

        InternalButtons internalPanel = new InternalButtons();
        internalPanel.pressButton(5, lift1);

        // Step 3: Simulation - Moving the elevator
        System.out.println("\n[SYSTEM] Starting Lift Simulation...");

        // Running a loop to simulate step-by-step movement.
        for(int i = 0; i < 7; i++) {
            lift1.move();
            
            // Break the loop if the elevator has finished all tasks and is IDLE
            if(lift1.state == ElevatorState.IDLE) {
                System.out.println("[SYSTEM] Lift has reached destination and is IDLE.");
                break;
            }
        }
    }
}
