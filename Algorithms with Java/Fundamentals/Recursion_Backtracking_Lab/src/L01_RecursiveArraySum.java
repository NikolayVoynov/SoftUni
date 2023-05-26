import java.util.Arrays;
import java.util.Scanner;

public class L01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int index = 0;

        System.out.println(sumElements(array, index));

    }

    private static int sumElements(int[] array, int index) {

        if (index >= array.length - 1) {
            return array[index];
        }


        return array[index] + sumElements(array, index + 1);
    }
}
