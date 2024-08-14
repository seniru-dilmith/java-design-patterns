package Creational;

class Car {
    private String engine;
    private String body;

    public void setEngine(String engine) { this.engine = engine; }
    public void setBody(String body) { this.body = body; }
    public String toString() { return "Car with " + this.engine + " engine and " + this.body + " body."; }
}

interface CarBuilder {
    void buildEngine();
    void buildBody();
    Car getCar();
}

class SportsCarBuilder implements CarBuilder {
    private Car car = new Car();

    public void buildEngine() { car.setEngine("V8 Engine"); }
    public void buildBody() { car.setBody("Sporty Body"); }
    public Car getCar() { return car; }
}

class Director {
    private CarBuilder builder;
    public Director(CarBuilder builder) { this.builder = builder; }
    public Car construct() {
        builder.buildEngine();
        builder.buildBody();
        return builder.getCar();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        CarBuilder builder = new SportsCarBuilder();
        Director director = new Director(builder);
        Car car = director.construct();
        System.out.println(car);
    }
}