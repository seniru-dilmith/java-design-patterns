# Iterator

## Description

Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation. It allows traversal of a collection without revealing the underlying structure. This pattern is particularly useful for collections and other aggregate objects.

## Java Code Example

```java
interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class NameRepository implements Container {
    public String names[] = {"John", "Jane", "Jack", "Jill"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        public boolean hasNext() {
            return index < names.length;
        }

        public Object next() {
            if(this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
```
