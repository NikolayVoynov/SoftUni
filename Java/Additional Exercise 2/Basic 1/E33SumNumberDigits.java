package Basic1;

import java.util.Scanner;

public class E33SumNumberDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");
        long number = Long.parseLong(scanner.nextLine());
        System.out.println("Sum of digits: " + sumDigits(number));
    }

    private static long sumDigits(long number) {
        long sum = 0;
        while (number != 0) {
            sum += number % 10;

            number /= 10;
        }

        return sum;
    }
}
