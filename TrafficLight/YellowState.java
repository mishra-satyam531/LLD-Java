package TrafficLight;

public class YellowState implements TrafficLightState {

    @Override
    public void action(TrafficLight signal) {
        System.out.println("SLOW DOWN");
        signal.setState(new RedState());
    }
    
}
