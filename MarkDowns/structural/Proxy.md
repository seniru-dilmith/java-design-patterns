# Proxy

## Description

Proxy pattern provides a surrogate or placeholder for another object to control access to it. It is useful when the object to be accessed is remote, expensive to create, or requires securing. This pattern allows you to control the access to the original object, adding a layer of security, caching, or logging.

## Java Code Example

```java
// Subject interface
interface Image {
    void display();
}

// RealSubject class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");

        // Image will be loaded from disk
        image.display();

        // Image will not be loaded from disk
        image.display();
    }
}
```

In this example:

* `Shape` is the flyweight interface with a method `draw` that concrete flyweights implement.
* `Circle` is a concrete flyweight class that implements `Shape`. It includes intrinsic properties (`color`) and extrinsic properties (`x`, `y`, `radius`).
* `ShapeFactory` is the flyweight factory that creates and manages the flyweight objects. It uses a `HashMap` to store and retrieve existing flyweights to avoid creating multiple objects of the same type.
* `FlyweightPatternDemo` is the client code that demonstrates the usage of the flyweight pattern.

When you run the `FlyweightPatternDemo` class, it will use the `ShapeFactory` to create and reuse `Circle` objects of different colors. This demonstrates how the flyweight pattern reduces the number of objects created and improves performance by sharing objects.
