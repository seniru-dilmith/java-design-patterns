package Behavioural;

// State interface
interface TrafficLightState {
    void handleRequest(TrafficLightContext context);
}

// Concrete state classes
class RedLightState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Red Light: Stop");
        context.setState(new GreenLightState());
    }
}

class YellowLightState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Yellow Light: Caution");
        context.setState(new RedLightState());
    }
}

class GreenLightState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Green Light: Go");
        context.setState(new YellowLightState());
    }
}

// Context class
class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        state = new RedLightState(); // Initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest(this);
    }
}

// Client code
public class StatePatternDemo {
    public static void main(String[] args) throws InterruptedException {
        TrafficLightContext trafficLight = new TrafficLightContext();

        for (int i = 0; i < 6; i++) {
            trafficLight.request();
            Thread.sleep(1000);
        }
    }
}