import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cakeCount = Integer.parseInt(scanner.nextLine());

        String name = "";
        String input = "";
        int points = 0;

        int maxPoints = Integer.MIN_VALUE;
        String maxPointsName = "";

        for (int i = 1; i <= cakeCount; i++) {

            name = scanner.nextLine();
            input = scanner.nextLine();

            int totalPoints = 0;

            while (!input.equals("Stop")) {
                points = Integer.parseInt(input);
                totalPoints += points;

                input = scanner.nextLine();
            }

            System.out.printf("%s has %d points.%n", name, totalPoints);

            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                maxPointsName = name;
                System.out.printf("%s is the new number 1!%n", name);

            }
        }
        System.out.printf("%s won competition with %d points!",maxPointsName ,maxPoints);
    }
}
