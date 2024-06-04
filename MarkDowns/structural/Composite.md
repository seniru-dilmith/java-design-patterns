# Composite

## Description

Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly. This pattern is particularly useful when you need to implement a tree-like structure.

## Java Code Example

```java
import java.util.ArrayList;
import java.util.List;

interface FileSystemElement {
    void listFiles();
}

class File implements FileSystemElement {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void listFiles() {
        System.out.println(name);
    }
}

class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void listFiles() {
        System.out.println(name + ":");
        for (FileSystemElement element : elements) {
            element.listFiles();
        }
    }
}

public class FileSystemClient {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");
        File file1 = new File("file1.txt");
        File file2 = new File("file2.jpg");

        root.addElement(dir1);
        root.addElement(dir2);
        dir1.addElement(file1);
        dir2.addElement(file2);

        root.listFiles();
    }
}
```
