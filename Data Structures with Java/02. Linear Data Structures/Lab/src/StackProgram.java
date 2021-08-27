import java.util.LinkedList;

public class StackProgram {

    static class Stack<T> {
        LinkedList<T> elements = new LinkedList<>();

        boolean isEmpty() {
            return this.elements.isEmpty();
        }

        void push(T element) {
            this.elements.add(element);
        }

        T pop() {
            T lastElement = this.elements.getLast();
            this.elements.removeLast();
            return lastElement;
        }

    }

    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        myStack.push("nikolay");
        myStack.push("borislav");
        myStack.push("george");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
