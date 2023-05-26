import java.util.Scanner;

public class L04_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numb = Integer.parseInt(scanner.nextLine());

        System.out.printf("%d", factorial(numb));

    }

    private static int factorial(int numb) {
        if (numb == 0) {
            return 1;
        }
        return numb * factorial(numb - 1);
    }
}
