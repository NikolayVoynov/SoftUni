import java.util.Scanner;

public class MER01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int wins = 0;
        boolean notEnoughEnergy = false;

        while (!input.equals("End of battle") && energy > 0) {
            int distance = Integer.parseInt(input);

            if (distance <= energy) {
                energy -= distance;
                wins++;

                if (wins % 3 == 0) {
                    energy += wins;
                }

            } else {
                notEnoughEnergy = true;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy"
                        , wins, energy);
            }
            input = scanner.nextLine();
        }

        if (notEnoughEnergy = false) {
            System.out.printf("Won battles: %d. Energy left: %d", wins, energy);
        }


    }
}
