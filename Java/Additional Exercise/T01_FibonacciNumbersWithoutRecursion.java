import java.util.Scanner;

public class T01_FibonacciNumbersWithoutRecursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert count of fibonacci numbers:");
        int count = Integer.parseInt(scanner.nextLine());

        int n1 = 0, n2 = 1, n3;
        System.out.print(n1 + " " + n2);

        for (int i = 2; i < count; i++) {
            n3 = n1 + n2;

            System.out.print(" " + n3);

            n1 = n2;
            n2 = n3;
        }
    }
}
