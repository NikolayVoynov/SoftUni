package E05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public long countValuesGreater(T valueToCompare) {

        return this.values.stream().filter(e -> e.compareTo(valueToCompare) > 0).count();
    }
}
