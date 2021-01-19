import java.util.Scanner;

public class L10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= n; num++) {
            String number = String.valueOf(num);
            int sumDigits = 0;

            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                sumDigits += (digit - 48);
            }

            if (sumDigits == 5 || sumDigits == 7 || sumDigits == 11) {
                System.out.printf("%d -> True%n", num);
            } else {
                System.out.printf("%d -> False%n", num);
            }
        }
    }
}
