import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());
        int fishermenEvenOrOdd = fishermen % 2;
        double rent = 0;
        double difference = 0;

        switch (season) {
            case "Spring":
                if (fishermen <= 6) {
                    rent = 3000 * 0.9;
                } else if (fishermen <= 11) {
                    rent = 3000 * 0.85;
                } else {
                    rent = 3000 * 0.75;
                }

                if (fishermenEvenOrOdd == 0) {
                    rent *= 0.95;
                } else {
                    rent *= 1;
                }

                difference = Math.abs(budget - rent);

                if (rent <= budget) {
                    System.out.printf("Yes! You have %.2f leva left.", difference);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", difference);
                }
                    break;
            case "Summer":
                if (fishermen <= 6) {
                    rent = 4200 * 0.9;
                } else if (fishermen <= 11) {
                    rent = 4200 * 0.85;
                } else {
                    rent = 4200 * 0.75;
                }

                if (fishermenEvenOrOdd == 0) {
                    rent *= 0.95;
                } else {
                    rent *= 1;
                }

                difference = Math.abs(budget - rent);

                if (rent <= budget) {
                    System.out.printf("Yes! You have %.2f leva left.", difference);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", difference);
                }
                break;
            case "Autumn":
                if (fishermen <= 6) {
                    rent = 4200 * 0.9;
                } else if (fishermen <= 11) {
                    rent = 4200 * 0.85;
                } else {
                    rent = 4200 * 0.75;
                }

                difference = Math.abs(budget - rent);

                if (rent <= budget) {
                    System.out.printf("Yes! You have %.2f leva left.", difference);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", difference);
                }
                break;
            case "Winter":
                if (fishermen <= 6) {
                    rent = 2600 * 0.9;
                } else if (fishermen <= 11) {
                    rent = 2600 * 0.85;
                } else {
                    rent = 2600 * 0.75;
                }

                if (fishermenEvenOrOdd == 0) {
                    rent *= 0.95;
                } else {
                    rent *= 1;
                }

                difference = Math.abs(budget - rent);

                if (rent <= budget) {
                    System.out.printf("Yes! You have %.2f leva left.", difference);
                } else {
                    System.out.printf("Not enough money! You need %.2f leva.", difference);
                }
                break;
        }
    }
}
