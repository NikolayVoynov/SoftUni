import java.util.Arrays;
import java.util.Scanner;

public class L07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

            for (int i = 0; i < numbers.length; i++) {
                int[] condensed = new int[numbers.length - 1];
                condensed[i] = numbers[i] + numbers[i + 1];
                numbers[i] = condensed[i];
            }


    }
}
