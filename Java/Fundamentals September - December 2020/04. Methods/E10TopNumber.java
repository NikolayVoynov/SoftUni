import java.util.Scanner;

public class E10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            if (sumOfDigitsDividesByEight(i) && holdAtLeastOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean sumOfDigitsDividesByEight(int i) {
        int sum = 0;
        while (i != 0) {
            int currentDigit = i % 10;
            sum += currentDigit;
            i = i / 10;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }

    private static boolean holdAtLeastOneOddDigit(int i) {
        while (i != 0) {
            int currentDigit = i % 10;
            i = i / 10;
            if (currentDigit % 2 !=0) {
                return true;
            }
        }
        return false;
    }
}
