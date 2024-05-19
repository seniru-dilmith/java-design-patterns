# Flyweight

## Description

Flyweight pattern reduces the cost of creating and manipulating a large number of similar objects. It is useful when a large number of objects must be created which share some state among them. This pattern provides a way to minimize memory usage or computational expenses by sharing as much as possible with similar objects.

## Java Code Example

```java
import java.util.HashMap;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x, y, radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}

public class FlyweightPattern {
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
    
    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }
    
    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
    
    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }
    
    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
```
