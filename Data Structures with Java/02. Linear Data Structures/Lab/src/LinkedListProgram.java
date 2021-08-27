import java.util.Objects;

public class LinkedListProgram {

    static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }

    static class LinkedList<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size;


        public void add(E element) {
            Node<E> newNode = new Node<>(element, null, tail);
            if (head == null) {
                head = newNode;
            }

            if (tail != null) {
                tail.setNext(newNode);
            }

            tail = newNode;
            size++;
        }

        public Node<E> getHead() {
            return head;
        }

        public void remove(Node<E> node) {
            if (node.getPrevious() != null) {
                node.getPrevious().setNext(node.getNext());
            }

            if (head == node) {
                head = node.getNext();
            }

            if (tail == node) {
                tail = node.getPrevious();
            }

            if (node.getNext() != null) {
                node.getNext().setPrevious(node.getPrevious());
            }

            size--;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> people = new LinkedList<>();
        people.add("joro");
        people.add("pesho");
        people.add("misho");
        people.add("grisho");

//        for (Node<String> node = people.getHead(); node != null; node = node.getNext()) {
//
//        }

        Node<String> node = people.getHead();
        while (node != null) {
            if (node.getElement().equals("pesho")) {
                people.remove(node);
            } else {
                System.out.println(node.getElement());
            }


            node = node.getNext();
        }

    }
}
