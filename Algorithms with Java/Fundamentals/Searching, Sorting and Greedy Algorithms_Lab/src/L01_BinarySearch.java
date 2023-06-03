import java.util.Arrays;
import java.util.Scanner;

public class L01_BinarySearch {
    public static int[] inputArray;
    public static int key;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        key = Integer.parseInt(scanner.nextLine());

        System.out.println(getIndex(inputArray, key));
    }

    private static int getIndex(int[] inputArray, int key) {
        int start = 0;
        int end = inputArray.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (key < inputArray[middle]) {
                end = middle - 1;
            } else if (key > inputArray[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
