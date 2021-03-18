package L05StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);

    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot pop from empty stack.");
        }
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot peek from empty stack.");
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
