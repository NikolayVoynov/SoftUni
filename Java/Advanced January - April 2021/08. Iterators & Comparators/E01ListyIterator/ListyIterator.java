package E01ListyIterator;

import java.util.List;

public class ListyIterator {
    private int index;
    private List<String> collection;

    public ListyIterator(List<String> collection) {
        this.collection = collection;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < this.collection.size() - 1;
    }

    public void print() {
        validatePrint();
        System.out.println(this.collection.get(index));
    }

    private void validatePrint() {
        if (this.collection.isEmpty()) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }
}
