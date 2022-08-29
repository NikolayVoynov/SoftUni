package Basic1;

import java.util.Scanner;

public class E86WhileDiffOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = Integer.parseInt(scanner.nextLine());

        while (n != 1) {

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n + 1) / 2;
            }1

            System.out.print("Input n: ");
            n = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Value of n = " + n);
    }
}
