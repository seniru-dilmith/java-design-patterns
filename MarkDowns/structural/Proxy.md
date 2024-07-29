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
* When you run the `ProxyPatternDemo` class, the `ProxyImage` object will control access to the `RealImage` object.
* The image will be loaded from disk the first time it is displayed.
* Subsequent displays will use the cached `RealImage` object without loading it again.
* This demonstrates how the proxy pattern can be used to add a layer of control over another object, optimizing performance by reducing unnecessary operations.

