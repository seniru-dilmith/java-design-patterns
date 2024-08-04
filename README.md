
# Design Patterns Repository

## Introduction to Design Patterns

Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code. They are not finished designs that can be transformed directly into code, but rather templates for how to solve problems that can be used in many different situations.

Design patterns can speed up the development process by providing tested, proven development paradigms. Effective software design requires considering issues that may not become visible until later in the implementation. Reusing design patterns helps to prevent subtle issues that can cause major problems and improves code readability for developers and architects who are familiar with the patterns.

Design patterns are divided into three main categories:

1. **Creational Patterns**: These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.
2. **Structural Patterns**: These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
3. **Behavioral Patterns**: These patterns are concerned with algorithms and the assignment of responsibilities between objects.

![image](https://github.com/seniru-dilmith/java-design-patterns/assets/104844292/e7434b1b-9d64-423d-8425-aa7d916148b4)

## Contents

### Creational Patterns
1. [Abstract Factory](MarkDowns/creational/Abstract%20Factory.md) (Virtual Constructor)
2. [Builder](MarkDowns/creational/Builder.md)
3. [Factory Method](MarkDowns/creational/Factory%20Method.md) 
4. [Prototype](MarkDowns/creational/Prototype.md) (Clone)
5. [Singleton](MarkDowns/creational/Singleton.md)

### Structural Patterns
1. [Adapter](MarkDowns/structural/Adapter.md) (Wrapper)
2. [Bridge](MarkDowns/structural/Bridge.md) 
3. [Composite](MarkDowns/structural/Composite.md) (Object Tree)
4. [Decorator](MarkDowns/structural/Decorator.md) (Wrapper)
5. [Facade](MarkDowns/structural/Facade.md)
6. [Flyweight](MarkDowns/structural/Flyweight.md) (Cache)
7. [Proxy](MarkDowns/structural/Proxy.md)

### Behavioral Patterns
1. [Chain of Responsibility](MarkDowns/behavioural/Chain%20Of%20Responsibility.md) (CoR / Chanin of Command)
2. [Command](MarkDowns/behavioural/Command.md) (Action / Transaction)
3. [Iterator](MarkDowns/behavioural/Iterator.md)
4. [Mediator](MarkDowns/behavioural/Mediator.md) (Intermediary / Controller)
5. [Memento](MarkDowns/behavioural/Memento.md) (Snapshot)
6. [Observer](MarkDowns/behavioural/Observer.md) (Event-Subscriber / Listener)
7. [State](MarkDowns/behavioural/State.md)
8. [Strategy](MarkDowns/behavioural/Strategy.md)
9. [Template Method](MarkDowns/behavioural/Template%20Method.md)
10. [Visitor](MarkDowns/behavioural/Visitor.md)
11. [Interpreter](MarkDowns/behavioural/Interpreter.md)


# Design Patterns and Keywords for Identification

## Design Patterns and Keywords

| **Design Pattern**           | **Keywords/Phrases**                                                                                      | **Example Scenarios**                                                                 |
|------------------------------|-----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
| **Factory Method**           | "create object", "subclasses decide", "instantiate", "defer instantiation to subclasses"                  | Document creation system (WordDocument, ExcelDocument)                                 |
| **Abstract Factory**         | "family of related objects", "without specifying concrete classes", "create families"                     | UI components for different operating systems (WindowsFactory, MacFactory)             |
| **Singleton**                | "single instance", "global point of access", "ensure one instance"                                        | Logger, configuration manager, database connection pool                                |
| **Builder**                  | "construct complex object", "step-by-step", "different representations", "immutable objects"              | Building complex objects like a house or assembling a car                              |
| **Prototype**                | "clone", "copy existing object", "prototype instance"                                                     | Object cloning in a graphics editor, game character customization                      |
| **Adapter**                  | "convert interface", "make compatible", "wrap existing class"                                             | Power plug adapters, converting legacy code interfaces to new interfaces               |
| **Bridge**                   | "decouple abstraction", "vary independently", "separate abstraction from implementation"                  | Remote control and devices (TV, DVD player), GUI toolkits                              |
| **Composite**                | "part-whole hierarchy", "tree structure", "compose objects"                                               | File system directories and files, graphical objects in a windowing system             |
| **Decorator**                | "add responsibilities", "dynamically", "wrap object"                                                      | Adding features to a window in a GUI, enhancing functionalities of a coffee            |
| **Facade**                   | "unified interface", "simplify", "higher-level interface"                                                 | Simplified APIs for complex libraries (e.g., jQuery), home theater system remote       |
| **Flyweight**                | "shared objects", "reduce memory usage", "fine-grained objects"                                           | String pooling in Java, reusable icon objects in an IDE                                |
| **Proxy**                    | "surrogate", "placeholder", "control access"                                                              | Virtual proxy for loading images, protection proxy for access control                  |
| **Chain of Responsibility**  | "pass request along chain", "multiple handlers", "decoupled sender and receiver"                          | Event handling systems in GUI frameworks, approval workflows in business processes     |
| **Command**                  | "encapsulate request", "parameterize objects", "queue requests", "undo operations"                        | Menu actions in GUIs, transaction management in databases                              |
| **Interpreter**              | "grammar", "language representation", "interpret sentences"                                               | Regular expressions, arithmetic expression evaluators                                  |
| **Iterator**                 | "sequential access", "traverse collection", "without exposing underlying representation"                  | Iterating over collections like lists and arrays, cursor movement in databases         |
| **Mediator**                 | "encapsulate interactions", "reduce direct communication", "centralize complex communications"            | Chat room applications, air traffic control systems                                    |
| **Memento**                  | "capture state", "restore state", "undo"                                                                  | Undo mechanisms in text editors, state saving in games                                 |
| **Observer**                 | "one-to-many dependency", "notify observers", "state changes"                                             | Notification systems, event listeners in GUIs                                          |
| **State**                    | "state-specific behavior", "change behavior with state", "state transition"                               | State machines, TCP connection states (e.g., CONNECTING, CONNECTED, DISCONNECTED)      |
| **Strategy**                 | "family of algorithms", "encapsulate algorithms", "interchangeable algorithms"                            | Sorting algorithms, payment methods in a shopping cart system                          |
| **Template Method**          | "define skeleton of algorithm", "defer steps to subclasses", "invariant steps"                            | Cooking recipes, steps in a manufacturing process                                      |
| **Visitor**                  | "perform operations", "separate algorithm from object structure", "add new operations"                    | Operations on a composite structure, adding functionality to objects in a hierarchy    |

- **Factory Method**: Look for scenarios where object creation is deferred to subclasses, allowing them to decide which class to instantiate.

- **Abstract Factory**: Identify scenarios that involve creating families of related objects without specifying their concrete classes.

- **Singleton**: Look for the need to ensure only one instance of a class and provide a global point of access.

- **Builder**: Recognize the need to construct complex objects step-by-step with various representations.

- **Prototype**: Look for the requirement to create new objects by copying an existing object (prototype).

- **Adapter**: Identify the need to convert one interface to another to make incompatible interfaces compatible.

- **Bridge**: Notice the need to decouple an abstraction from its implementation so they can vary independently.

- **Composite**: Look for scenarios that involve part-whole hierarchies and the composition of objects into tree structures.

- **Decorator**: Recognize the need to dynamically add responsibilities to objects without modifying their structure.

- **Facade**: Identify the need to provide a simplified, unified interface to a set of interfaces in a subsystem.

- **Flyweight**: Look for the need to share objects to reduce memory usage, especially with many fine-grained objects.

- **Proxy**: Notice the requirement to provide a surrogate or placeholder for another object to control access.

- **Chain of Responsibility**: Identify scenarios where a request is passed along a chain of handlers, with each handler having a chance to process it.

- **Command**: Recognize the need to encapsulate requests as objects, allowing parameterization, queuing, and undoing operations.

- **Interpreter**: Look for the need to interpret sentences in a language, usually represented by a grammar.

- **Iterator**: Identify the need to traverse a collection of elements sequentially without exposing the underlying representation.

- **Mediator**: Notice the requirement to encapsulate interactions between objects, reducing direct communication and dependencies.

- **Memento**: Recognize the need to capture and restore an object's state without violating encapsulation.

- **Observer**: Look for scenarios where a one-to-many dependency exists, and observers need to be notified of state changes.

- **State**: Identify the need for an object to change its behavior when its internal state changes.

- **Strategy**: Recognize the need to define a family of algorithms and make them interchangeable within a context.

- **Template Method**: Notice the requirement to define the skeleton of an algorithm, allowing subclasses to implement specific steps.

- **Visitor**: Look for scenarios where operations need to be performed on elements of an object structure without changing the classes of the elements.

## License

This work is licensed under [Creative Commons Zero v1.0 Universal](LICENSE).

