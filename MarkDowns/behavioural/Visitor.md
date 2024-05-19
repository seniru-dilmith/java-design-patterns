# Visitor

## Description

Visitor pattern lets you separate algorithms from the objects on which they operate. It allows adding new operations to existing object structures without modifying the structures. This pattern is useful for defining new operations without changing the classes of the elements on which it operates.

## Java Code Example

```java
interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}

class Keyboard implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Mouse implements ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Computer implements ComputerPart {
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
```
