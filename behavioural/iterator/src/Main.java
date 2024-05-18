import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete iterator class for a list
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ListIterator(List<T> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(index++);
        }
        throw new IndexOutOfBoundsException("No more elements");
    }
}

// Aggregate interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// Concrete aggregate class for a list
class ListAggregate<T> implements Aggregate<T> {
    private List<T> list;

    public ListAggregate() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(list);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        ListAggregate<String> aggregate = new ListAggregate<>();
        aggregate.add("Item 1");
        aggregate.add("Item 2");
        aggregate.add("Item 3");

        Iterator<String> iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

