import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int numberMax = Integer.MIN_VALUE;
        int currentNumber = 0;

        while (!input.equals("Stop")) {
            currentNumber = Integer.parseInt(input);

            if (currentNumber > numberMax) {
                numberMax = currentNumber;
            }
            input = scanner.nextLine();
        }
        System.out.println(numberMax);
    }
}
