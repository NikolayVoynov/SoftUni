import java.util.Scanner;

public class L03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] items = input.split(" ");
        int[] numbers = new int[items.length];

        int sum = 0;

        for (int i = 0; i < items.length ; i++) {
            numbers[i] = Integer.parseInt(items[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }

        System.out.printf("%d", sum);

    }
}
