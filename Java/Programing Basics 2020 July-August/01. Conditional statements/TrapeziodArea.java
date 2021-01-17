import java.io.Console;
import java.util.Scanner;

public class TrapeziodArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double b1 = Integer.parseInt(scanner.nextLine());
        double b2 = Integer.parseInt(scanner.nextLine());
        double h = Integer.parseInt(scanner.nextLine());

        double trapeziodArea = (b1 + b2) * h / 2;
        System.out.printf("%.2f", trapeziodArea);
    }
}
