# Memento

## Description

Memento pattern provides the ability to restore an object to its previous state. It is useful for implementing undo mechanisms. This pattern captures and externalizes an object's internal state so that the object can be restored to this state later without violating encapsulation.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

// Memento class
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator class
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("State set to: " + state);
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        System.out.println("Saving state to Memento: " + state);
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("State restored from Memento: " + state);
    }
}

// Caretaker class
class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

// Client code
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

In this example:

* `Memento` is the memento class that stores the state of the `Originator`.
* `Originator` is the class whose state needs to be saved and restored. It creates a `Memento` containing a snapshot of its current state and can restore its state from a `Memento`.
* `Caretaker` is the class that manages the memento objects, keeping track of the saved states.
* `MementoPatternDemo` is the client code that demonstrates the usage of the memento pattern.

When you run the `MementoPatternDemo` class, it will create an `Originator` and a `Caretaker`. The originator will change its state and save it to mementos managed by the caretaker. Later, it will restore its state from the mementos, demonstrating how the memento pattern provides the ability to restore an object to a previous state without exposing its implementation details.

