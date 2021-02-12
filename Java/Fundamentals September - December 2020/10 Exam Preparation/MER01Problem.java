import java.util.Scanner;

public class MER01Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterDayPerson = Double.parseDouble(scanner.nextLine());
        double foodDayPerson = Double.parseDouble(scanner.nextLine());

        double waterTotal = n * countPlayers * waterDayPerson;

        double foodTotal = n * countPlayers * foodDayPerson;

        boolean energyFinished = false;

        for (int i = 1; i <= n; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLoss;

            if (groupEnergy > 0) {
                if (i % 2 == 0) {
                    waterTotal *= 0.7;
                    groupEnergy *= 1.05;
                }

                if (i % 3 == 0) {
                    foodTotal -= (foodTotal / countPlayers);
                    groupEnergy *= 1.1;

                }
            } else {
                energyFinished = true;
                break;
            }

        }

        if (energyFinished) {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water."
                    , foodTotal, waterTotal);

        } else {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);

        }





    }
}
