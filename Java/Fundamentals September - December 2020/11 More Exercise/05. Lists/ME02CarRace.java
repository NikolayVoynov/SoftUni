import java.util.Arrays;
import java.util.Scanner;

public class ME02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] timesLeftRight = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        double timeLeft = 0;
        double timeRight = 0;

        for (int i = 0; i < timesLeftRight.length / 2; i++) {
            if (timesLeftRight[i] != 0) {
                timeLeft += timesLeftRight[i];
            } else {
                timeLeft = timeLeft * 0.8;
            }

            if (timesLeftRight[timesLeftRight.length - 1 - i] != 0) {
                timeRight += timesLeftRight[timesLeftRight.length - 1 - i];
            } else {
                timeRight = timeRight * 0.8;
            }
        }

        if (timeLeft < timeRight) {
            System.out.printf("The winner is left with total time: %.1f", timeLeft);
        } else {
            System.out.printf("The winner is right with total time: %.1f", timeRight);
        }


    }
}
