# Decorator

## Description

Decorator pattern allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class. It is useful for adhering to the Single Responsibility Principle by allowing functionality to be divided between classes with unique areas of concern. This pattern provides a flexible alternative to subclassing for extending functionality.

## Java Code Example

```java
interface Car {
    void assemble();
}

class BasicCar implements Car {
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

class CarDecorator implements Car {
    protected Car decoratedCar;
    
    public CarDecorator(Car c) {
        this.decoratedCar = c;
    }
    
    public void assemble() {
        this.decoratedCar.assemble();
    }   
}

class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
    }
}
```
