package TrafficLight;

public class YellowState implements TrafficLightState {

    @Override
    public void action() {
        System.out.println("SLOW DOWN");
    }
    
}
