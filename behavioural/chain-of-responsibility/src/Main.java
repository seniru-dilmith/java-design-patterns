// Handler interface
interface Handler {
    void setNext(Handler handler);
    void handleRequest(Request request);
}

// Concrete handler class
class ConcreteHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("Type1")) {
            System.out.println("Handled Type1 request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for request");
        }
    }
}

// Request class
class Request {
    private String type;

    public Request(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler();

        // Chain the handlers
        handler1.setNext(handler2);
        handler2.setNext(handler3);

        // Create requests
        Request request1 = new Request("Type1");
        Request request2 = new Request("Type2");

        // Process requests
        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
    }
}
