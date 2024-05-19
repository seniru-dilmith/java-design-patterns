# Singleton

## Description

Singleton pattern ensures a class has only one instance and provides a global point of access to it. It is useful when exactly one object is needed to coordinate actions across the system. This pattern is often used for managing shared resources such as database connections or thread pools.

## Java Code Example

```java
class Singleton {
    private static Singleton instance;
    
    private Singleton() { }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);  // true
    }
}
```
