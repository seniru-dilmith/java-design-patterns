# Factory Method

## Description

Factory Method defines an interface for creating an object, but lets subclasses alter the type of objects that will be created. It allows a class to delegate the responsibility of object instantiation to its subclasses, promoting loose coupling. This pattern is particularly useful when the exact type of the object to be created is not known until runtime.

## Java Code Example

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    public Animal createAnimal() {
        return new Cat();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        AnimalFactory factory1 = new DogFactory();
        Animal animal1 = factory1.createAnimal();
        animal1.makeSound();
        
        AnimalFactory factory2 = new CatFactory();
        Animal animal2 = factory2.createAnimal();
        animal2.makeSound();
    }
}
```
