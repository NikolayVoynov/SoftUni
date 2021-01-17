import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int minNumber = Integer.MAX_VALUE;
        int currentNumber = 0;

        while (!input.equals("Stop")) {
            currentNumber = Integer.parseInt(input);

            if (currentNumber < minNumber) {
                minNumber = currentNumber;
            }
            input = scanner.nextLine();
        }
        System.out.println(minNumber);
    }
}
