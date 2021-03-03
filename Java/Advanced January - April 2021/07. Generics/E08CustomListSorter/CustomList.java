package E08CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        this.values.add(value);
    }

    public T remove(int index) {
        return this.values.remove(index);
    }

    public boolean contains(T value) {
        return this.values.contains(value);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.values, index1, index2);
    }

    public long countGreaterThan(T compareToValue) {
        return this.values.stream().filter(e -> e.compareTo(compareToValue) > 0).count();
    }

    public T getMax() {
        T maxValue = null;
        if (!this.values.isEmpty()) {
            maxValue = this.values.get(0);
            for (T value : this.values) {
                if (value.compareTo(maxValue) > 0) {
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }

    public T getMin() {
        T minValue = null;
        if (!this.values.isEmpty()) {
            minValue = this.values.get(0);
            for (T value : this.values) {
                if (value.compareTo(minValue) < 0) {
                    minValue = value;
                }
            }
        }

        return minValue;
    }

    public int size() {
        return this.values.size();
    }

    public T get(int index) {
        return this.values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : this.values) {
            sb
                    .append(value.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }


}
