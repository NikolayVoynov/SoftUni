package E02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private int index;
    private List<String> collection;

    public ListyIterator(List<String> collection) {
        this.collection = collection;
    }

    public boolean move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }
        return false;
    }


    public void print() {
        validatePrint();
        System.out.println(this.collection.get(index));
    }

    public void printAll() {
        validatePrint();
        collection.forEach(e -> System.out.print(e + " "));
    }

    private void validatePrint() {
        if (this.collection.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index < collection.size() - 1;
            }

            @Override
            public String next() {
                String element = collection.get(index);
                index++;
                return element;
            }
        };
    }
}
