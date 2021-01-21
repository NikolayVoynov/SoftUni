import java.util.Scanner;

public class L04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                printResultAdd(a, b);
                break;
            case "multiply":
                printResultMultiply(a, b);
                break;
            case "subtract":
                printResultSubtract(a, b);
                break;
            case "divide":
                printResultDivide(a, b);
                break;
        }
    }

    public static void printResultAdd(int a, int b) {
        System.out.print(a + b);
    }

    public static void printResultMultiply(int a, int b) {
        System.out.print(a * b);
    }

    public static void printResultSubtract(int a, int b) {
        System.out.print(a - b);
    }

    public static void printResultDivide(int a, int b) {
        System.out.print(a / b);
    }
}
