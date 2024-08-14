package Behavioural;

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