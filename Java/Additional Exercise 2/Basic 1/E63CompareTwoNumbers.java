package Basic1;

import java.util.Scanner;

public class E63CompareTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n1: ");
        int n1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Input n2: ");
        int n2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Result: " + result(n1, n2));

    }

    private static int result(int n1, int n2) {

        if (n1 == n2) {
            return 0;
        } else {
            if (n1 % 6 == n2 % 6) {
                return Math.min(n1, n2);
            }
            return Math.max(n1, n2);
        }
    }
}
