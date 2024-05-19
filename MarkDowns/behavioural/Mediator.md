# Mediator

## Description

Mediator pattern defines an object that encapsulates how a set of objects interact. This pattern promotes loose coupling by keeping objects from referring to each other explicitly, and it allows you to vary their interaction independently. It is particularly useful for handling complex communication between multiple objects.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void sendMessage(String message, User user) {
        for(User u : this.users) {
            if(u != user) {
                u.receive(message);
            }
        }
    }
}

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    public void send(String message) {
        System.out.println(this.name + ": Sending Message = " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + ": Received Message = " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        
        User user1 = new UserImpl(mediator, "John");
        User user2 = new UserImpl(mediator, "Jane");
        User user3 = new UserImpl(mediator, "Jack");
        User user4 = new UserImpl(mediator, "Jill");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi everyone!");
    }
}
```
