# Strategy

## Description

Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern allows the algorithm to vary independently from clients that use it. It is useful for defining a set of related algorithms and making them easily interchangeable.

## Java Code Example

```java
// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategy classes
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPayment(String email, String password) {
        this.emailId = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

// Context class
class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

// Item class
class Item {
    private String upcCode;
    private int price;

    public Item(String upc, int cost) {
        this.upcCode = upc;
        this.price = cost;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }
}

// Client code
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        // Pay by credit card
        cart.pay(new CreditCardPayment("John Doe", "1234567890123456", "786", "12/15"));

        // Pay by PayPal
        cart.pay(new PayPalPayment("myemail@example.com", "mypwd"));
    }
}

```

In this example:

* `PaymentStrategy` is the strategy interface with a method `pay` that concrete strategy classes implement.
* `CreditCardPayment` and `PayPalPayment` are concrete strategy classes that implement the `pay` method and provide different payment methods.
* `ShoppingCart` is the context class that maintains a list of items and uses a `PaymentStrategy` to process payments.
* `Item` is a class representing an item with a UPC code and price.
* `StrategyPatternDemo` is the client code that demonstrates the usage of the strategy pattern.

When you run the `StrategyPatternDemo` class, it will create a `ShoppingCart`, add items to it, and then process payments using different strategies (`CreditCardPayment` and `PayPalPayment`). This demonstrates how the strategy pattern allows the behavior of a class to be selected at runtime.
