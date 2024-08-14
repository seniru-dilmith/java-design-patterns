package Creational;

interface Animal {
    void makeSound();
}

class Dog1 implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory1 {
    abstract Animal createAnimal();
}

class Dog1Factory extends AnimalFactory1 {
    public Animal createAnimal() {
        return new Dog1();
    }
}

class CatFactory extends AnimalFactory1 {
    public Animal createAnimal() {
        return new Cat();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        AnimalFactory1 factory1 = new Dog1Factory();
        Animal animal1 = factory1.createAnimal();
        animal1.makeSound();

        AnimalFactory1 factory2 = new CatFactory();
        Animal animal2 = factory2.createAnimal();
        animal2.makeSound();
    }
}