import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    void operation();
}

// Leaf class
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Composite class
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite:");
        for (Component component : children) {
            component.operation();
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create leaf components
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");

        // Create composite component
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // Create another composite component with leaf and composite
        Composite composite2 = new Composite();
        composite2.add(leaf3);
        composite2.add(composite);

        // Call operation on composite
        composite2.operation();
    }
}
