// Subsystem classes
class SubsystemA {
    public void operationA() {
        System.out.println("SubsystemA operation");
    }
}

class SubsystemB {
    public void operationB() {
        System.out.println("SubsystemB operation");
    }
}

class SubsystemC {
    public void operationC() {
        System.out.println("SubsystemC operation");
    }
}

// Facade class
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    public void operation() {
        System.out.println("Facade operation:");
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create facade object
        Facade facade = new Facade();

        // Call facade operation
        facade.operation();
    }
}
