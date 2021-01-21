import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = calculateFactorial(firstNum) / calculateFactorial(secondNum);

        System.out.printf("%.2f", result);
    }

    private static double calculateFactorial(int n) {
        double factorial = 1.0;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }


}
