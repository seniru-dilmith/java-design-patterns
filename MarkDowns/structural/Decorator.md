# Decorator

## Description

Decorator pattern allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class. It is useful for adhering to the Single Responsibility Principle by allowing functionality to be divided between classes with unique areas of concern. This pattern provides a flexible alternative to subclassing for extending functionality.

## Java Code Example

```java
// Coffee interface
interface Coffee {
    String getDescription();
    double getCost();
}

// SimpleCoffee class that implements Coffee
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// Abstract decorator class that implements Coffee
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// MilkDecorator class that extends CoffeeDecorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

// SugarDecorator class that extends CoffeeDecorator
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

// Main class to test the decorator pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.getCost());
    }
}
```

In this example:

* `SimpleCoffee` is the basic component that implements the `Coffee` interface.
* `CoffeeDecorator` is an abstract class that implements the `Coffee` interface and contains a reference to a `Coffee` object.
* `MilkDecorator` and `SugarDecorator` are concrete decorators that extend `CoffeeDecorator` and add their own behavior to the `getDescription` and `getCost` methods.

When you run the `DecoratorPatternDemo` class, it will output the descriptions and costs of the coffee as it gets decorated with milk and sugar.

