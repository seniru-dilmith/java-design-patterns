# AbstractFactory

## Description

Abstract Factory provides an interface for creating families of related or dependent objects without specifying their concrete classes. It separates the details of implementation of a set of objects from their general usage. This pattern is useful when the client doesn't know exactly what type to create. An abstract factory can create multiple types of objects which are related, without specifying the exact class.

## Java Code Example

```java
interface Chair {
    void sit();
}

class VictorianChair implements Chair {
    public void sit() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

class ModernChair implements Chair {
    public void sit() {
        System.out.println("Sitting on a Modern chair.");
    }
}

interface ChairFactory {
    Chair createChair();
}

class VictorianChairFactory implements ChairFactory {
    public Chair createChair() {
        return new VictorianChair();
    }
}

class ModernChairFactory implements ChairFactory {
    public Chair createChair() {
        return new ModernChair();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        ChairFactory factory1 = new VictorianChairFactory();
        Chair chair1 = factory1.createChair();
        chair1.sit();
        
        ChairFactory factory2 = new ModernChairFactory();
        Chair chair2 = factory2.createChair();
        chair2.sit();
    }
}
```
