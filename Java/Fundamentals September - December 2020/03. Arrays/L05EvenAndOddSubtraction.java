import java.util.Arrays;
import java.util.Scanner;

public class L05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        int difference = evenSum - oddSum;
        System.out.print(difference);

    }
}
