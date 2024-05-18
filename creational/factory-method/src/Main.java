// Product interface
interface Product {
    void display();
}

// Concrete product classes
class ConcreteProduct1 implements Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product 1.");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void display() {
        System.out.println("This is Concrete Product 2.");
    }
}

// Creator interface
interface Creator {
    Product createProduct();
}

// Concrete creator classes
class ConcreteCreator1 implements Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProduct1();
    }
}

class ConcreteCreator2 implements Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Creator creator1 = new ConcreteCreator1();
        Product product1 = creator1.createProduct();
        product1.display();

        Creator creator2 = new ConcreteCreator2();
        Product product2 = creator2.createProduct();
        product2.display();
    }
}
