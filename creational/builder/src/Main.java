// Product class
class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, and " + topping + " topping.";
    }
}

// Builder class
class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    public PizzaBuilder withDough(String dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder withSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    public PizzaBuilder withTopping(String topping) {
        pizza.setTopping(topping);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        PizzaBuilder builder = new PizzaBuilder();
        Pizza pizza = builder.withDough("thin").withSauce("tomato").withTopping("cheese").build();
        System.out.println(pizza);
    }
}
