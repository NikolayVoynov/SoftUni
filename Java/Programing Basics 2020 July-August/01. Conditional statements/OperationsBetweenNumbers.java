import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String symbol = scanner.nextLine();

        double result = 0;

        switch (symbol) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 != 0) {
                    result = 1.0 * n1 / n2;
                    System.out.printf("%d / %d = %.2f", n1, n2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
            case "%":
                if (n2 != 0) {
                    result = n1 % n2;
                    System.out.printf("%d %% %d = %.0f", n1, n2, result);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
                }

        if (!symbol.equals("/") && !symbol.equals("%")) {
            String type = "";
            String dash = "-";
            if (result % 2 == 0) {
                type = "even";
            } else {
                type = "odd";
            }
            System.out.printf("%d %s %d = %.0f %s %s", n1, symbol, n2, result, dash, type);

        }
    }
}
