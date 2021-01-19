import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        boolean isSpecialNumber = false;
        for (int ch = 1; ch <= n; ch++) {
            int number = ch;
            while (ch > 0) {
                sum += ch % 10;
                ch = ch / 10;
            }
           if (isSpecialNumber = (sum == 5) || (sum == 7) || (sum == 11)) {
               System.out.printf("%d -> True%n", number);
            } else {
               System.out.printf("%d -> False%n", number);
           }
            sum = 0;
            ch = number;
        }
    }
}
