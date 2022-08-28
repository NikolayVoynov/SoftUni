package Basic1;

import java.util.Scanner;

public class E17SumBinaryNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] binarySum = new int[30];
        int remainder = 0;
        int i = 0;

        System.out.println("Input first binary number:");
        long binary1 = Long.parseLong(scanner.nextLine());
        System.out.println("Input second binary number:");
        long binary2 = Long.parseLong(scanner.nextLine());

        while (binary1 != 0 || binary2 != 0) {
            binarySum[i++] = (int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }

        if (remainder != 0) {
            binarySum[i] = remainder;
        }

        System.out.println("Sum of two binary numbers is:");
        while (i >= 0) {
            System.out.print(binarySum[i--]);
        }


    }
}
