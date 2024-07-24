# Chain Of Responsibility (CoR / Chain of Command)

## Description

Chain of Responsibility pattern passes a request along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain. This pattern allows an object to send a request without knowing which object will handle it, promoting loose coupling.

## Java Code Example

```java
// Abstract handler class
abstract class Logger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // Next element in chain of responsibility
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

// Concrete handler classes
class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

class ErrorLogger extends Logger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

// Main class to test the Chain of Responsibility pattern
public class ChainPatternDemo {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        System.out.println("First Request=====================");
        loggerChain.logMessage(Logger.INFO, "This is an information.");
        System.out.println("==================================\n");

        System.out.println("First Request=====================");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug level information.");
        System.out.println("==================================\n");

        System.out.println("Third Request=====================");
        loggerChain.logMessage(Logger.ERROR, "This is an error information.");
        System.out.println("==================================");
    }
}
```

In this example:

* `Logger` is the abstract handler class with a method `logMessage` that processes the log message and passes it to the next logger in the chain if necessary. It has an abstract method `write` that concrete loggers implement.
* `ConsoleLogger`, `ErrorLogger`, and `FileLogger` are concrete handler classes that extend `Logger` and implement the `write` method to handle logging in different ways.
* `ChainPatternDemo` is the main class that sets up the chain of responsibility and demonstrates its usage.

When you run the `ChainPatternDemo` class, it will create a chain of loggers (`ErrorLogger` -> `FileLogger` -> `ConsoleLogger`) and process log messages at different levels (`INFO`, `DEBUG`, `ERROR`). The chain of responsibility pattern is demonstrated by passing log messages through the chain until an appropriate handler processes them.

