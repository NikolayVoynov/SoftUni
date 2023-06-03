import java.util.Arrays;
import java.util.Scanner;

public class L03_Quicksort {

    public static int[] inputArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        print(quicksort(inputArr));
    }

    private static int[] quicksort(int[] array) {
        return quicksort(array, 0, array.length - 1);
    }

    private static int[] quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }

        return array;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static void print(int[] quicksort) {
        StringBuilder sb = new StringBuilder();

        for (int elem : quicksort) {
            sb.append(elem).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
