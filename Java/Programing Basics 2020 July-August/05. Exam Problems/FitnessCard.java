import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double sportCard = 0;

        if (gender.equals("m")) {
            if (age <= 19) {
                switch (sport) {
                    case "Gym":
                        sportCard = 42 * 0.8;
                        break;
                    case "Boxing":
                        sportCard = 41 * 0.8;
                        break;
                    case "Yoga":
                        sportCard = 45 * 0.8;
                        break;
                    case "Zumba":
                        sportCard = 34 * 0.8;
                        break;
                    case "Dances":
                        sportCard = 51 * 0.8;
                        break;
                    case "Pilates":
                        sportCard = 39 * 0.8;
                        break;
                }

            } else {
                switch (sport) {
                    case "Gym":
                        sportCard = 42;
                        break;
                    case "Boxing":
                        sportCard = 41;
                        break;
                    case "Yoga":
                        sportCard = 45;
                        break;
                    case "Zumba":
                        sportCard = 34;
                        break;
                    case "Dances":
                        sportCard = 51;
                        break;
                    case "Pilates":
                        sportCard = 39;
                        break;
                }

            }

        } else if (gender.equals("f")) {
            if (age <= 19) {
                switch (sport) {
                    case "Gym":
                        sportCard = 35 * 0.8;
                        break;
                    case "Boxing":
                        sportCard = 37 * 0.8;
                        break;
                    case "Yoga":
                        sportCard = 42 * 0.8;
                        break;
                    case "Zumba":
                        sportCard = 31 * 0.8;
                        break;
                    case "Dances":
                        sportCard = 53 * 0.8;
                        break;
                    case "Pilates":
                        sportCard = 37 * 0.8;
                        break;
                }

            } else {
                switch (sport) {
                    case "Gym":
                        sportCard = 35;
                        break;
                    case "Boxing":
                        sportCard = 37;
                        break;
                    case "Yoga":
                        sportCard = 42;
                        break;
                    case "Zumba":
                        sportCard = 31;
                        break;
                    case "Dances":
                        sportCard = 53;
                        break;
                    case "Pilates":
                        sportCard = 37;
                        break;
                }

            }

        }

        if (sportCard > budget) {
            System.out.printf("You don't have enough money! You need $%.2f more.", sportCard - budget);

        } else {
            System.out.printf("You purchased a 1 month pass for %s.", sport);

        }
    }
}
