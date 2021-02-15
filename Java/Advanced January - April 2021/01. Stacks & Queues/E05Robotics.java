import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInputLine = scanner.nextLine().split(";");

        String[] nameRobot = new String[firstInputLine.length];
        int[] timeProcessing = new int[firstInputLine.length];

        for (int i = 0; i < firstInputLine.length; i++) {
            String[] robotInfo = firstInputLine[i].split("-");
            nameRobot[i] = robotInfo[0];
            timeProcessing[i] = Integer.parseInt(robotInfo[1]);
        }


        int[] beginning = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int hours = beginning[0];
        int minutes = beginning[1];
        int seconds = beginning[2];
        int startTimeSeconds = hours * 3600 + minutes * 60 + seconds;


        String inputProductionLine = scanner.nextLine();

        ArrayDeque<String> queueProducts = new ArrayDeque<>();

        while (!inputProductionLine.equals("End")) {
            queueProducts.offer(inputProductionLine);

            inputProductionLine = scanner.nextLine();
        }

        int[] robotsWorkLeft = new int[nameRobot.length];

        while (!queueProducts.isEmpty()) {
            startTimeSeconds++;
            String product = queueProducts.poll();
            int index = -1;

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }

                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsWorkLeft[index] = timeProcessing[index];
                System.out.println(printRobotData(nameRobot[index], product, startTimeSeconds));
            } else {
                queueProducts.offer(product);
            }
        }
    }

    private static String printRobotData(String name, String product, int beginTime) {
        int seconds = beginTime % 60;
        int minutes = (beginTime / 60) % 60;
        int hours = beginTime / (60 * 60) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        String printInfo = String.format("%s - %s [%s]", name, product, time);

        return printInfo;
    }
}
