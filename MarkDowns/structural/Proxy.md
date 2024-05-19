# Proxy

## Description

Proxy pattern provides a surrogate or placeholder for another object to control access to it. It is useful when the object to be accessed is remote, expensive to create, or requires securing. This pattern allows you to control the access to the original object, adding a layer of security, caching, or logging.

## Java Code Example

```java
interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        image.display(); // loading necessary
        image.display(); // loading unnecessary
    }
}
```
