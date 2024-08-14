package Behavioural;

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