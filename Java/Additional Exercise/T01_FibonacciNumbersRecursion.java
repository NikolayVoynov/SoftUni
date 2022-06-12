import java.util.Scanner;

public class T01_FibonacciNumbersRecursion {
    static int n1 = 0;
    static int n2 = 1;
    static int n3;

    static void printFibonacciNumber(int count) {
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            System.out.print(" " + n3);
            printFibonacciNumber(count - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert Fibonacci count:");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.print(n1 + " " + n2);

        printFibonacciNumber(count -2);
    }
}
