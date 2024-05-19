// Target interface
interface Target {
    void request();
}

// Adaptee class with incompatible interface
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Adapter class implementing the target interface and using the adaptee
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create an adaptee object
        Adaptee adaptee = new Adaptee();

        // Create an adapter object and pass adaptee to it
        Target adapter = new Adapter(adaptee);

        // Call request method of the adapter
        adapter.request();
    }
}
