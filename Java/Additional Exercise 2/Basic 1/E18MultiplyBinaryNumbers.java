package Basic1;

import java.util.Scanner;

public class E18MultiplyBinaryNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int digit, factor = 1;
        long multiply = 0;

        System.out.print("Input 1st binary number:");
        long binary1 = Long.parseLong(scanner.nextLine());
        System.out.print("Input 2nd binary number:");
        long binary2 = Long.parseLong(scanner.nextLine());

        while (binary2 != 0) {
            digit = (int) (binary2 % 10);

            if (digit == 1) {
                binary1 = binary1 * factor;
                multiply = binaryProduct((int) binary1, (int) multiply);

            } else {
                binary1 = binary1 * factor;
            }
            binary2 /= 10;
            factor = 10;
        }

        System.out.println("Product of two binary numbers: " + multiply);
    }

    private static int binaryProduct(int binary1, int binary2) {
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        int binary_prod_result = 0;

        while (binary1 != 0 || binary2 != 0)
        {
            sum[i++] = (binary1 % 10 + binary2 % 10 + remainder) % 2;
            remainder = (binary1 % 10 + binary2 % 10 + remainder) / 2;
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0)
        {
            sum[i++] = remainder;
        }
        --i;
        while (i >= 0)
        {
            binary_prod_result = binary_prod_result * 10 + sum[i--];
        }
        return binary_prod_result;
    }
}
