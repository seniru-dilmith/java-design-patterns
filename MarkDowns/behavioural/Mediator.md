# Mediator (Intermediary / Controller)

## Description

Mediator pattern defines an object that encapsulates how a set of objects interact. This pattern promotes loose coupling by keeping objects from referring to each other explicitly, and it allows you to vary their interaction independently. It is particularly useful for handling complex communication between multiple objects.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator class
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : this.users) {
            // Message should not be received by the user sending it
            if (u != user) {
                u.receive(message);
            }
        }
    }
}

// Abstract User class
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Concrete User classes
class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}

// Client code
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Alice(user1)");
        User user2 = new UserImpl(mediator, "Bob(user2)");
        User user3 = new UserImpl(mediator, "Charlie(user3)");
        User user4 = new UserImpl(mediator, "Diana(user4)");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello everyone!");
    }
}
```

In this example:

* `ChatMediator` is the mediator interface with methods `sendMessage` and `addUser` that concrete mediators implement.
* `ChatMediatorImpl` is the concrete mediator class that implements `ChatMediator` and handles the communication between users.
* `User` is the abstract user class that holds a reference to the mediator and provides methods for sending and receiving messages.
* `UserImpl` is the concrete user class that extends `User` and implements the methods for sending and receiving messages.
* `MediatorPatternDemo` is the client code that demonstrates the usage of the mediator pattern.

When you run the `MediatorPatternDemo` class, it will create a chat mediator and several users. Users will send messages via the mediator, which will handle the communication and ensure that messages are delivered to the appropriate users. This demonstrates how the mediator pattern centralizes complex communication and control logic between objects, promoting loose coupling.

