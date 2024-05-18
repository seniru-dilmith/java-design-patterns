// Abstraction interface
interface Shape {
    void draw();
}

// Concrete abstraction classes
class Circle implements Shape {
    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.print("Drawing a circle. ");
        color.applyColor();
    }
}

class Square implements Shape {
    private Color color;

    public Square(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.print("Drawing a square. ");
        color.applyColor();
    }
}

// Implementor interface
interface Color {
    void applyColor();
}

// Concrete implementor classes
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Color: Red");
    }
}

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Color: Blue");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create shapes with different colors
        Shape circle = new Circle(new RedColor());
        Shape square = new Square(new BlueColor());

        // Draw shapes
        circle.draw();
        square.draw();
    }
}
