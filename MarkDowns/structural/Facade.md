# Facade

## Description

Facade pattern provides a simplified interface to a complex subsystem. It offers a high-level interface that makes the subsystem easier to use. This pattern is particularly useful when a system is very complex or difficult to understand.

## Java Code Example

```java
class CPU {
    public void start() {
        System.out.println("CPU started.");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory loaded.");
    }
}

class HardDrive {
    public void read() {
        System.out.println("Hard Drive read.");
    }
}

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
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started.");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
```
