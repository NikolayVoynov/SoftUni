import java.util.Scanner;

public class L10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 0) {
            number = Math.abs(number);
        }

        int result = getMultipleOfEvenAndOdds(number);
        System.out.printf("%d", result);

    }

    public static int getMultipleOfEvenAndOdds(int number) {
        int evensSum = getSumOfEvenDigits(number);
        int oddsSum = getSumOfOddDigits(number);

        return evensSum * oddsSum;
    }

    public static int getSumOfEvenDigits(int number) {
        int evensSum = 0;

        while (number > 0) {
            int digit = number % 10;

            if (digit % 2 == 0) {
                evensSum += digit;
            }

            number /= 10;
        }

        return evensSum;
    }

    public static int getSumOfOddDigits(int number) {
        int oddsSum = 0;

        while (number > 0) {
            int digit = number % 10;

            if (digit % 2 != 0) {
                oddsSum += digit;
            }

            number /= 10;
        }

        return oddsSum;

    }


}
