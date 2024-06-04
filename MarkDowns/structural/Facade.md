# Facade

## Description

Facade pattern provides a simplified interface to a complex subsystem. It offers a high-level interface that makes the subsystem easier to use. This pattern is particularly useful when a system is very complex or difficult to understand.

## Java Code Example

```java
// Subsystem classes
class CPU {
    public void freeze() {
        System.out.println("CPU is frozen");
    }

    public void jump(long position) {
        System.out.println("CPU jumps to position " + position);
    }

    public void execute() {
        System.out.println("CPU is executing");
    }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory loading data at position " + position);
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive reading " + size + " bytes from LBA " + lba);
        return new byte[size];
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }
}

// Main class to test the Facade pattern
public class FacadePatternDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
```

In this example:

* `CPU`, `Memory`, and `HardDrive` are subsystem classes with their own functionality.
* `ComputerFacade` is the facade class that simplifies the interaction with these subsystems by providing a single method `start` to start the computer.

When you run the `FacadePatternDemo` class, it will use the `ComputerFacade` to start the computer, hiding the complexity of the subsystem interactions.

