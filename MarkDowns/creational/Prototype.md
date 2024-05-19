# Prototype

## Description

Prototype pattern allows you to copy existing objects without making your code dependent on their classes. It provides a way to create new objects as copies of existing objects, reducing the need for repetitive initialization code. This pattern is particularly useful when object creation is a costly operation and you need to create multiple similar objects.

## Java Code Example

```java
interface Prototype extends Cloneable {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private String name;
    public ConcretePrototype(String name) { this.name = name; }
    public Prototype clone() {
        return new ConcretePrototype(name);
    }
    public String toString() { return name; }
}

public class PrototypePattern {
    public static void main(String[] args) {
        ConcretePrototype prototype1 = new ConcretePrototype("Prototype1");
        ConcretePrototype cloned1 = (ConcretePrototype) prototype1.clone();
        System.out.println(cloned1);
        
        ConcretePrototype prototype2 = new ConcretePrototype("Prototype2");
        ConcretePrototype cloned2 = (ConcretePrototype) prototype2.clone();
        System.out.println(cloned2);
    }
}
```
