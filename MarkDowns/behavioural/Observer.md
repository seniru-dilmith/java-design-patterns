# Observer (Event-Subscriber / Listner)

## Description

Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. It is useful for implementing distributed event-handling systems. This pattern allows a subject to be observed by multiple observers, promoting loose coupling between the objects.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

// Subject class
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer interface
abstract class Observer {
    protected Subject subject;

    public abstract void update();
}

// Concrete Observer classes
class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}

class HexaObserver extends Observer {
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

// Client code
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
        System.out.println();

        new OctalObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
        System.out.println();

        new HexaObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
```

In this example:

* `Subject` is the subject class that maintains a list of observers and notifies them of any state changes.
* `Observer` is the abstract observer class that all concrete observers extend.
* `BinaryObserver`, `OctalObserver`, and `HexaObserver` are concrete observer classes that implement the `update` method to react to state changes in the subject.
* `ObserverPatternDemo` is the client code that demonstrates the usage of the observer pattern.

When you run the `ObserverPatternDemo` class, it will create a `Subject` and several observers (`BinaryObserver`, `OctalObserver`, `HexaObserver`). The subject will notify its observers whenever its state changes, demonstrating how the observer pattern allows a subject to maintain a list of its dependents (observers) and automatically notify them of any state changes.

