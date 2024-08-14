package Structural;

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