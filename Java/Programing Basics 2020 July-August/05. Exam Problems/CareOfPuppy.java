import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int availableFoodKG = Integer.parseInt(scanner.nextLine());

        int availableFoodGrams = availableFoodKG * 1000;

        int consumedFood = 0;

        String input = scanner.nextLine();

        while (!input.equals("Adopted")) {

            int food = Integer.parseInt(input);

            consumedFood += food;

            input = scanner.nextLine();
        }

        if (availableFoodGrams >= consumedFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", Math.abs(availableFoodGrams - consumedFood));
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(availableFoodGrams - consumedFood));
        }
    }
}
