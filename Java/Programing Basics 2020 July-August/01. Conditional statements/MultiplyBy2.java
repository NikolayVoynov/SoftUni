import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double numberMultiplyBy2 = 0;


        while (number >= 0) {
            numberMultiplyBy2 = number * 2;
            System.out.printf("Result: %.2f%n", numberMultiplyBy2);
            number = Double.parseDouble(scanner.nextLine());
        }
        if (number < 0) {
            System.out.println("Negative number!");
        }
    }
}
