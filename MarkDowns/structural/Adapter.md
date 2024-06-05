# Adapter

## Description

Adapter pattern allows objects with incompatible interfaces to collaborate. It works as a bridge between two incompatible interfaces, enabling them to work together. This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.

## Java Code Example

```java
// Target interface
interface Socket {
    Volt getVolt();
}

// Adaptee class
class WallSocket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

// Volt class to represent voltage
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

// Adapter class
class SocketAdapter implements Socket {
    private WallSocket wallSocket;

    public SocketAdapter(WallSocket wallSocket) {
        this.wallSocket = wallSocket;
    }

    @Override
    public Volt getVolt() {
        Volt v = wallSocket.getVolt();
        return convertVolt(v, 10);
    }

    private Volt convertVolt(Volt v, int i) {
        return new Volt(v.getVolts() / i);
    }
}

// Main class to test the Adapter pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        WallSocket wallSocket = new WallSocket();
        Socket socketAdapter = new SocketAdapter(wallSocket);

        Volt v120 = wallSocket.getVolt();
        Volt v12 = socketAdapter.getVolt();

        System.out.println("Wall Socket Voltage: " + v120.getVolts() + "V");
        System.out.println("Adapter Voltage: " + v12.getVolts() + "V");
    }
}
```

In this example:

* `Socket` is the target interface with a method `getVolt` that clients use.
* `WallSocket` is the adaptee class with a method `getVolt` that returns 120 volts.
* `Volt` is a class to represent voltage.
* `SocketAdapter` is the adapter class that implements `Socket` and adapts the interface of `WallSocket` to the `Socket` interface by converting the voltage.
* `AdapterPatternDemo` is the main class that demonstrates the usage of the adapter.

When you run the `AdapterPatternDemo` class, it will use the `SocketAdapter` to convert the 120V from the `WallSocket` to 12V, demonstrating how the adapter pattern works by adapting the voltage.

