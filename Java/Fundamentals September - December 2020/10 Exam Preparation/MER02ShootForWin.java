import java.util.Arrays;
import java.util.Scanner;

public class MER02ShootForWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] shotTargets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index < shotTargets.length) {

                if (shotTargets[index] != -1) {
                    int currentTargetValue = shotTargets[index];
                    shotTargets[index] = -1;

                    for (int i = 0; i < shotTargets.length; i++) {

                        if (shotTargets[i] != -1) {
                            if (shotTargets[i] > currentTargetValue) {
                                shotTargets[i] -= currentTargetValue;
                            } else {
                                shotTargets[i] += currentTargetValue;
                            }
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        int countShotTargets = 0;

        String targetsCurrentState = "";

        for (int shotTarget : shotTargets) {

            if (shotTarget == -1) {
                countShotTargets++;
            }

        }

        System.out.println("Shot targets: " + countShotTargets + " -> "
                + Arrays.toString(shotTargets).replaceAll("[\\[\\],]", ""));
    }
}
