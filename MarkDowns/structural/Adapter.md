# Adapter (Wrapper)

## Description

Adapter pattern allows objects with incompatible interfaces to collaborate. It works as a bridge between two incompatible interfaces, enabling them to work together. This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.

## Java Code Example

```java
// Target interface
interface Target {
    void request();
}

// Adaptee class with incompatible interface
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Adapter class implementing the target interface and using the adaptee
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create an adaptee object
        Adaptee adaptee = new Adaptee();

        // Create an adapter object and pass adaptee to it
        Target adapter = new Adapter(adaptee);

        // Call request method of the adapter
        adapter.request();
    }
}
```

In this example:

* `Target` is the target interface with a method `request` that clients use.
* `Adaptee` is the adaptee class with a method `specificRequest` that has an incompatible interface.
* `Adapter` is the adapter class that implements `Target` and adapts the interface of `Adaptee` to the `Target` interface.
* `Main` is the client code that demonstrates the usage of the adapter.

When you run the `Main` class, it will use the `Adapter` to call the `specificRequest` method of the `Adaptee` through the `request` method of the `Target` interface, demonstrating how the adapter pattern works by adapting the `Adaptee` to the `Target` interface.


