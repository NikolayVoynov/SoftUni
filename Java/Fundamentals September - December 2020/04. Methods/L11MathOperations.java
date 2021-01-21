import java.util.Scanner;

public class L11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        double calculationResult = calculate(a, operator, b);
        System.out.printf("%.0f", calculationResult);
    }

    private static double calculate(int a, String operator, int b) {
        double result = 0.0;

        switch (operator) {
            case "/":
                result = (int) (a / b);
                break;
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }
        return result;
    }
}
