import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    class DynamicArray<E> {
        boolean add(E element) {

        }

        E get(int index) {

        }

        E set(int index, E element) {

        }

        E remove(int index) {

        }

        int size() {

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(4, 1, 32, 15, 96, 42, 7, 15));
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
