package Behavioural;

import java.util.*;

// Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Container interface
interface Container {
    Iterator getIterator();
}

// Concrete collection class for List
class NameListRepository implements Container {
    private List<String> names = new ArrayList<>();

    public NameListRepository() {
        names.add("John");
        names.add("Jane");
        names.add("Jack");
        names.add("Jill");
    }

    @Override
    public Iterator getIterator() {
        return new NameListIterator();
    }

    // Concrete iterator class for List
    private class NameListIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names.get(index++);
            }
            return null;
        }
    }
}

// Concrete collection class for Set
class NameSetRepository implements Container {
    private Set<String> names = new HashSet<>();

    public NameSetRepository() {
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Diana");
    }

    @Override
    public Iterator getIterator() {
        return new NameSetIterator();
    }

    // Concrete iterator class for Set
    private class NameSetIterator implements Iterator {
        private java.util.Iterator<String> iterator = names.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return iterator.next();
            }
            return null;
        }
    }
}

// Concrete collection class for HashTable
class NameHashTableRepository implements Container {
    private Hashtable<Integer, String> names = new Hashtable<>();

    public NameHashTableRepository() {
        names.put(1, "Tom");
        names.put(2, "Jerry");
        names.put(3, "Spike");
    }

    @Override
    public Iterator getIterator() {
        return new NameHashTableIterator();
    }

    // Concrete iterator class for HashTable
    private class NameHashTableIterator implements Iterator {
        private java.util.Iterator<Map.Entry<Integer, String>> iterator = names.entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return iterator.next().getValue();
            }
            return null;
        }
    }
}

// Concrete collection class for Map
class NameMapRepository implements Container {
    private Map<Integer, String> names = new HashMap<>();

    public NameMapRepository() {
        names.put(1, "Max");
        names.put(2, "Bella");
        names.put(3, "Charlie");
    }

    @Override
    public Iterator getIterator() {
        return new NameMapIterator();
    }

    // Concrete iterator class for Map
    private class NameMapIterator implements Iterator {
        private java.util.Iterator<Map.Entry<Integer, String>> iterator = names.entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return iterator.next().getValue();
            }
            return null;
        }
    }
}

// Concrete collection class for LinkedList
class NameLinkedListRepository implements Container {
    private LinkedList<String> names = new LinkedList<>();

    public NameLinkedListRepository() {
        names.add("Oscar");
        names.add("Olivia");
        names.add("Oliver");
    }

    @Override
    public Iterator getIterator() {
        return new NameLinkedListIterator();
    }

    // Concrete iterator class for LinkedList
    private class NameLinkedListIterator implements Iterator {
        private java.util.Iterator<String> iterator = names.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return iterator.next();
            }
            return null;
        }
    }
}

// Concrete collection class for BinarySearchTree
class NameBSTRepository implements Container {
    private TreeSet<String> names = new TreeSet<>();

    public NameBSTRepository() {
        names.add("George");
        names.add("Gina");
        names.add("Greg");
    }

    @Override
    public Iterator getIterator() {
        return new NameBSTIterator();
    }

    // Concrete iterator class for BinarySearchTree
    private class NameBSTIterator implements Iterator {
        private java.util.Iterator<String> iterator = names.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return iterator.next();
            }
            return null;
        }
    }
}

// Client code
public class IteratorPatternDemo {
    public static void main(String[] args) {
        // List-based repository
        NameListRepository nameListRepository = new NameListRepository();
        System.out.println("Names from List:");
        for (Iterator iter = nameListRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // Set-based repository
        NameSetRepository nameSetRepository = new NameSetRepository();
        System.out.println("\nNames from Set:");
        for (Iterator iter = nameSetRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // HashTable-based repository
        NameHashTableRepository nameHashTableRepository = new NameHashTableRepository();
        System.out.println("\nNames from HashTable:");
        for (Iterator iter = nameHashTableRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // Map-based repository
        NameMapRepository nameMapRepository = new NameMapRepository();
        System.out.println("\nNames from Map:");
        for (Iterator iter = nameMapRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // LinkedList-based repository
        NameLinkedListRepository nameLinkedListRepository = new NameLinkedListRepository();
        System.out.println("\nNames from LinkedList:");
        for (Iterator iter = nameLinkedListRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // BinarySearchTree-based repository
        NameBSTRepository nameBSTRepository = new NameBSTRepository();
        System.out.println("\nNames from BinarySearchTree:");
        for (Iterator iter = nameBSTRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}