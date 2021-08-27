import java.util.LinkedList;

public class QueueProgram {
    static class Queue<T> {
        LinkedList<T> elements = new LinkedList<>();

        boolean isEmpty() {
            return this.elements.isEmpty();
        }

        void offer(T element) {
            this.elements.add(element);
        }

        T poll() {
            T lastElement = this.elements.getFirst();
            this.elements.removeFirst();
            return lastElement;
        }

    }

    public static void main(String[] args) {
        Queue<String> myQueue = new Queue<>();

        myQueue.offer("nikolay");
        myQueue.offer("borislav");
        myQueue.offer("george");

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
}
