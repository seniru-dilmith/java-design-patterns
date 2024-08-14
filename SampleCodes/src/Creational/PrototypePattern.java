package Creational;

interface Prototype {
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