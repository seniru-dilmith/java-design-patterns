import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}

// Concrete mediator class
class ConcreteChatMediator implements ChatMediator {
    private List<User> users;

    public ConcreteChatMediator() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague class
class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create mediator
        ChatMediator mediator = new ConcreteChatMediator();

        // Create users
        User user1 = new User("User1", mediator);
        User user2 = new User("User2", mediator);
        User user3 = new User("User3", mediator);

        // Add users to mediator
        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        // Send message
        user1.sendMessage("Hello, everyone!");
    }
}
