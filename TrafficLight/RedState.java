package TrafficLight;

public class RedState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("STOP");
        signal.setState(new GreenState());
    }
    
}
