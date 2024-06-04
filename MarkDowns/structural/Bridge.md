# Bridge

## Description

Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. It allows you to vary not only your implementations but also your abstractions. This pattern is used when you need to decouple an abstraction from its implementation so that the two can evolve independently.

## Java Code Example

```java
// Abstraction (Device)
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete Implementation 1 (TV)
class TV implements Device {
    private RemoteControl remote;

    public TV(RemoteControl remote) {
        this.remote = remote;
    }

    @Override
    public void turnOn() {
        remote.turnOn();
        System.out.println("TV is turned on");
    }

    @Override
    public void turnOff() {
        remote.turnOff();
        System.out.println("TV is turned off");
    }
}

// Concrete Implementation 2 (Radio)
class Radio implements Device {
    private RemoteControl remote;

    public Radio(RemoteControl remote) {
        this.remote = remote;
    }

    @Override
    public void turnOn() {
        remote.turnOn();
        System.out.println("Radio is turned on");
    }

    @Override
    public void turnOff() {
        remote.turnOff();
        System.out.println("Radio is turned off");
    }
}

// Implementation (RemoteControl)
interface RemoteControl {
    void turnOn();
    void turnOff();
}

// Concrete Implementation 1 (RemoteControlA)
class RemoteControlA implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Turning on with RemoteControlA");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off with RemoteControlA");
    }
}

// Concrete Implementation 2 (RemoteControlB)
class RemoteControlB implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Turning on with RemoteControlB");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off with RemoteControlB");
    }
}

// Client code
public class BridgePatternExample {
    public static void main(String[] args) {
        RemoteControl remoteControlA = new RemoteControlA();
        RemoteControl remoteControlB = new RemoteControlB();

        Device tv = new TV(remoteControlA);
        Device radio = new Radio(remoteControlB);

        tv.turnOn();
        tv.turnOff();

        radio.turnOn();
        radio.turnOff();
    }
}
```

The Bridge Design Pattern is a structural pattern that decouples an abstraction from its implementation, allowing both to vary independently. This pattern is useful when you have multiple variations of an abstraction and multiple implementations of that abstraction.

In this example:

- `Device` is the abstraction, which defines the common interface for devices.
- `TV` and `Radio` are concrete implementations of the `Device` abstraction.
- `RemoteControl` is the implementation interface, which defines the actions that can be performed on devices.
- `RemoteControlA` and `RemoteControlB` are concrete implementations of the `RemoteControl` interface.

The `TV` and `Radio` classes take a `RemoteControl` object in their constructors, allowing them to be configured with different remote control implementations. This decouples the device implementation from the remote control implementation, enabling them to vary independently.

In the `main` method, we create instances of `TV` and `Radio` with different remote control implementations (`RemoteControlA` and `RemoteControlB`). We then call the `turnOn` and `turnOff` methods on these devices, which in turn calls the corresponding methods on the associated remote control implementation.

This example demonstrates how the Bridge Pattern allows you to decouple the abstraction (`Device`) from its implementation (`RemoteControl`), enabling you to create different combinations of devices and remote controls without modifying the existing code.
