package TrafficLight;

public class GreenState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("GO");
        signal.setState(new YellowState());
    }
    
}
