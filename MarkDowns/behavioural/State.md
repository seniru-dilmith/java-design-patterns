# State

## Description

State pattern allows an object to alter its behavior when its internal state changes. It appears as if the object changed its class. This pattern is particularly useful for state-dependent behavior and for implementing state machines.

## Java Code Example

```java
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
```

In this example:

* `TrafficLightState` is the state interface with a method `handleRequest` that concrete state classes implement.
* `RedLightState`, `YellowLightState`, and `GreenLightState` are concrete state classes that implement the `handleRequest` method and perform actions specific to the state they represent.
* `TrafficLightContext` is the context class that maintains an instance of a concrete state class and provides a method to set the current state and to handle state-specific requests.
* `StatePatternDemo` is the client code that demonstrates the usage of the state pattern.

When you run the `StatePatternDemo` class, it will create a `TrafficLightContext` and repeatedly change its state by invoking the `request` method, cycling through the states `RedLightState`, `GreenLightState`, and `YellowLightState`. This demonstrates how the state pattern allows an object to alter its behavior when its internal state changes.

