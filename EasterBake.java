import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxSugar = Integer.MIN_VALUE;
        int maxFlour = Integer.MIN_VALUE;

        int totalSugar = 0;
        int totalFlour = 0;

        int bakeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= bakeCount; i++) {
            int sugarCurrent = Integer.parseInt(scanner.nextLine());
            int flourCurrent = Integer.parseInt(scanner.nextLine());

            totalSugar += sugarCurrent;
            totalFlour += flourCurrent;

            if (sugarCurrent > maxSugar) {
                maxSugar = sugarCurrent;
            }

            if (flourCurrent > maxFlour) {
                maxFlour = flourCurrent;
            }
        }

        double packagesSugarNeeded = Math.ceil(totalSugar * 1.0 / 950);
        double packagesFlourNeeded = Math.ceil(totalFlour * 1.0 / 750);

        System.out.printf("Sugar: %.0f%n", packagesSugarNeeded);
        System.out.printf("Flour: %.0f%n", packagesFlourNeeded);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxFlour, maxSugar);
    }
}
