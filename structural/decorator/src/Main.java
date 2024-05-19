// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete component class
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double cost() {
        return 1.0;
    }
}

// Decorator class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete decorator classes
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: " + coffee.cost() + ", Description: " + coffee.getDescription());

        // Add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println("Cost: " + coffee.cost() + ", Description: " + coffee.getDescription());

        // Add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println("Cost: " + coffee.cost() + ", Description: " + coffee.getDescription());
    }
}
