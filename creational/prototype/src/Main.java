// Prototype interface
interface Prototype {
    Prototype clone();
}

// Concrete prototype classes
class ConcretePrototype implements Prototype {
    private String attribute;

    public ConcretePrototype(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public Prototype clone() {
        // Perform a shallow copy or deep copy as needed
        return new ConcretePrototype(this.attribute);
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a prototype object
        ConcretePrototype original = new ConcretePrototype("Original Attribute");

        // Clone the prototype to create a new object
        ConcretePrototype clone = (ConcretePrototype) original.clone();

        // Modify the cloned object
        clone.setAttribute("Modified Attribute");

        // Print attributes of original and cloned objects
        System.out.println("Original Attribute: " + original.getAttribute());
        System.out.println("Cloned Attribute: " + clone.getAttribute());
    }
}
