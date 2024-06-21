# Visitor

## Description

Visitor pattern lets you separate algorithms from the objects on which they operate. It allows adding new operations to existing object structures without modifying the structures. This pattern is useful for defining new operations without changing the classes of the elements on which it operates.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

// Element interface
interface ItemElement {
    void accept(ShoppingCartVisitor visitor);
}

// Concrete elements
class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int price, String isbn) {
        this.price = price;
        this.isbnNumber = isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int wt, String nm) {
        this.pricePerKg = priceKg;
        this.weight = wt;
        this.name = nm;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface ShoppingCartVisitor {
    void visit(Book book);
    void visit(Fruit fruit);
}

// Concrete visitor
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public void visit(Book book) {
        int cost = book.getPrice();
        System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
    }

    @Override
    public void visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
    }
}

// Client code
public class VisitorPatternDemo {
    public static void main(String[] args) {
        List<ItemElement> items = new ArrayList<>();
        items.add(new Book(20, "1234"));
        items.add(new Book(100, "5678"));
        items.add(new Fruit(10, 2, "Banana"));
        items.add(new Fruit(5, 5, "Apple"));

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(List<ItemElement> items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            item.accept(visitor);
        }
        return sum;
    }
}
```

In this example:

* `ItemElement` is the element interface with an `accept` method that takes a `ShoppingCartVisitor`.
* `Book` and `Fruit` are concrete elements that implement the `accept` method, allowing a visitor to process them.
* `ShoppingCartVisitor` is the visitor interface with `visit` methods for each concrete element type.
* `ShoppingCartVisitorImpl` is a concrete visitor that implements the `visit` methods to calculate the cost of books and fruits.
* `VisitorPatternDemo` is the client code that demonstrates the usage of the visitor pattern.

When you run the `VisitorPatternDemo` class, it creates a list of `ItemElement` objects (books and fruits), and calculates their prices using the `ShoppingCartVisitorImpl`. This demonstrates how the visitor pattern allows adding new operations to existing object structures without modifying the structures.

