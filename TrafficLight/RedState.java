package TrafficLight;

public class RedState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("STOP");
    }
    
}
