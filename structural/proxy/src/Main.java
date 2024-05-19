// Subject interface
interface Image {
    void display();
}

// Real subject class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy class
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a proxy image object
        Image image = new ProxyImage("test.jpg");

        // Image will be loaded from disk only when needed
        image.display();

        // Image will be loaded from disk only once
        image.display();
    }
}
