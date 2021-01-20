import java.util.Arrays;
import java.util.Scanner;

public class L0301SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        String[] items = inputLine.split(" ");

        int[] numbers = Arrays.stream(items).mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }

        }

        System.out.printf("%d", sum);

    }
}
