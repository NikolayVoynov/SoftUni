import java.util.Arrays;
import java.util.Scanner;

public class AloneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int target = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < numbers.length - 1; i++) {
            if (target == numbers[i]) {
                int left = numbers[i - 1];
                int right = numbers[i + 1];

                if (left != target && right != target) {
                    if (left > right) {
                        numbers[i] = left;
                    } else {
                        numbers[i] = right;
                    }
                }
            }
        }

        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        System.out.println("[" + String.join(", ", result) + "]");
    }
}
