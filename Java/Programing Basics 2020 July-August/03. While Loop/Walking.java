import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        int sumSteps = 0;

        while (sumSteps < goal) {
            String input = scanner.nextLine();

            if (input.equals("Going home")) {
                int steps = Integer.parseInt(scanner.nextLine());
                sumSteps += steps;
                break;
            }
            sumSteps += Integer.parseInt(input);
        }
            if (sumSteps >= goal) {
                System.out.printf("Goal reached! Good job!%n%d steps over the goal!", Math.abs(sumSteps - goal));
            } else {
                System.out.printf("%d more steps to reach goal.", Math.abs(sumSteps - goal));
            }
    }
}
