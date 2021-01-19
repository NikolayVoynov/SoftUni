import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumLiters = 0;
        int sumLitersFinal = 0;

        for (int i = 1; i <= n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            sumLiters += liters;

            if (sumLiters <= 255) {
                sumLitersFinal += liters;
            } else {
                System.out.println("Insufficient capacity!");
                sumLiters -= liters;
            }
        }
        System.out.print(sumLitersFinal);
    }
}
