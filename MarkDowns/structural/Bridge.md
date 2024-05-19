# Bridge

## Description

Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. It allows you to vary not only your implementations but also your abstractions. This pattern is used when you need to decouple an abstraction from its implementation so that the two can evolve independently.

## Java Code Example

```java
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

class GreenCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw(); 
}

class Circle extends Shape {
    private int x, y, radius;
    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;  
        this.y = y;  
        this.radius = radius;
    }
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}
```
