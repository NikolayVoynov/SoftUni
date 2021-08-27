import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArrayProgram {

    class ArrayList<E> {
        private Object[] elements = new Object[1];
        private int size = 0;

        boolean add(E element) {
            elements[size] = element;
            size++;

            if (size >= elements.length) {
                Object[] newElements = new Object[size * 2];

                for (int i = 0; i < elements.length; i++) {
                    newElements[i] = elements[i];
                }

                elements = newElements;
            }

            return true;
        }

        E get(int index) {
            checkIndex(index);
            return (E) elements[index];

        }

        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException();
            }
        }

        E set(int index, E element) {
            elements[index] = element;
            return element;
        }

        E remove(int index) {
            E removedElement = (E) elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }

            size--;
            return removedElement;
        }

        int size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<>(Arrays.asList(4, 1, 32, 15, 96, 42, 7, 15));
        numbers.add(13);

        int[] counts = new int[101];

        for (Integer number : numbers) {
            counts[number]++;
        }

        for (int number = 0; number <= 100; number++) {
            int count = counts[number];

            for (int i = 0; i < count; i++) {
                System.out.println(number + " ");
            }
        }

    }
}
