import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottles = Integer.parseInt(scanner.nextLine());
        int washerQuantity = bottles * 750;

        String command = scanner.nextLine();

        int counter = 0;

        int washerPots = 0;
        int countPots = 0;
        int washerDishes = 0;
        int countDishes = 0;
        int washerDishesPots = 0;
        int difference = 0;

        while (!command.equals("End")) {
            int input = Integer.parseInt(command);
            counter++;

            if (counter % 3 == 0) {
                countPots += input;
                washerPots = countPots * 15;
            } else {
                countDishes += input;
                washerDishes = countDishes * 5;
            }
            washerDishesPots = washerPots + washerDishes;
            difference = washerQuantity - washerDishesPots;

            if (difference < 0) {
                break;
            }

            command = scanner.nextLine();
        }

        if (washerDishesPots <= washerQuantity) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", countDishes, countPots);
            System.out.printf("Leftover detergent %d ml.", Math.abs(difference));

        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(washerQuantity - washerDishesPots));
        }
    }
}
