# Command

## Description

Command pattern turns a request into a stand-alone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations. It encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

## Java Code Example

```java
// Command interface
interface Command {
    void execute();
}

// Receiver class
class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

// Concrete command classes
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
```

In this example:

* `Command` is the command interface with a method `execute` that concrete command classes implement.
* `Light` is the receiver class that performs the actual operations (`on` and `off`).
* `LightOnCommand` and `LightOffCommand` are concrete command classes that implement `Command` and call the appropriate method on the `Light` receiver.
* `RemoteControl` is the invoker class that stores a command and calls its `execute` method.
* `CommandPatternDemo` is the client code that demonstrates the usage of the command pattern.

When you run the `CommandPatternDemo` class, it will use the `RemoteControl` to execute commands (`lightOn` and `lightOff`) on the `Light` receiver, demonstrating how the command pattern works by encapsulating a request as an object and allowing parameterization of clients with different requests.

