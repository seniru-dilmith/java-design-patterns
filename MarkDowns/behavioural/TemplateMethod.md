# TemplateMethod

## Description

Template Method pattern defines the skeleton of an algorithm in an operation, deferring some steps to subclasses. This pattern allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.

## Java Code Example

```java
// Abstract class with the template method
abstract class DataProcessor {
    // Template method
    public final void process() {
        readData();
        processData();
        writeData();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void readData();
    protected abstract void processData();
    protected abstract void writeData();
}

// Concrete class implementing the abstract methods
class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing data from CSV file");
    }

    @Override
    protected void writeData() {
        System.out.println("Writing data to CSV file");
    }
}

// Another concrete class implementing the abstract methods
class XMLDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from XML file");
    }

    @Override
    protected void processData() {
        System.out.println("Processing data from XML file");
    }

    @Override
    protected void writeData() {
        System.out.println("Writing data to XML file");
    }
}

// Client code
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();

        System.out.println();

        DataProcessor xmlProcessor = new XMLDataProcessor();
        xmlProcessor.process();
    }
}
```

In this example:

* `DataProcessor` is an abstract class with a template method `process` that defines the steps for processing data. The steps include reading data, processing data, and writing data.
* `readData`, `processData`, and `writeData` are abstract methods that concrete subclasses must implement.
* `CSVDataProcessor` and `XMLDataProcessor` are concrete classes that implement the `readData`, `processData`, and `writeData` methods to handle CSV and XML data processing, respectively.
* `TemplateMethodPatternDemo` is the client code that demonstrates the usage of the template method pattern.

When you run the `TemplateMethodPatternDemo` class, it will create instances of `CSVDataProcessor` and `XMLDataProcessor` and call their `process` methods. This demonstrates how the template method pattern allows subclasses to redefine certain steps of an algorithm without changing the algorithm's structure.
