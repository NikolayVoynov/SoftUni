import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counterDays = 1;
        int totalDistance = 5364;

        String input = scanner.nextLine();

        while (true) {
            String command = scanner.nextLine();
            int distance = Integer.parseInt(scanner.nextLine());

            if (command.equals("Yes")) {
                counterDays++;
            }

            if (counterDays > 5) {
                System.out.println("Failed!");
                System.out.printf("%d", totalDistance);
                break;
            }

            totalDistance += distance;

            if (totalDistance >= 8848) {
                System.out.printf("Goal reached for %d days!", counterDays);
                break;
            }
        }
    }
}
