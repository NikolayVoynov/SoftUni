package Basic1;

import java.util.Scanner;

public class E32CompareTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n1: ");
        int n1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Input n2: ");
        int n2 = Integer.parseInt(scanner.nextLine());

        if (n1 == n2) {
            System.out.printf("%d == %d\n", n1, n2);
        }
        if (n1 != n2) {
            System.out.printf("%d != %d\n", n1, n2);
        }
        if (n1 >= n2) {
            System.out.printf("%d >= %d\n", n1, n2);
        }
        if (n1 <= n2) {
            System.out.printf("%d <= %d\n", n1, n2);
        }
        if (n1 < n2) {
            System.out.printf("%d < %d\n", n1, n2);
        }
        if (n1 > n2) {
            System.out.printf("%d > %d\n", n1, n2);
        }
    }
}
