package TrafficLight;

public class GreenState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("GO");
    }
    
}
