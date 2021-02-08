import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MER03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String command = token[0];
            int index = Integer.parseInt(token[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(token[2]);
                    if (index < targetsValues.size()) {
                        targetsValues.set(index, targetsValues.get(index) - power);

                        if (targetsValues.get(index) <= 0) {
                            targetsValues.remove(index);
                        }
                    }
                    break;

                case "Add":
                    int value = Integer.parseInt(token[2]);
                    if (index < targetsValues.size()) {
                        targetsValues.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;

                case "Strike":
                    int radius = Integer.parseInt(token[2]);
                    int downBorder = index - radius;
                    int upperBorder = index + radius;

                    if (downBorder >= 0 && upperBorder < targetsValues.size()) {

                        List<Integer> newListTargets = new ArrayList<>();

                        if (downBorder != 0) {
                            for (int i = 0; i < downBorder; i++) {
                                newListTargets.add(targetsValues.get(i));
                            }
                        }

                        if (upperBorder < targetsValues.size() - 1) {
                            for (int i = upperBorder + 1; i < targetsValues.size(); i++) {
                                newListTargets.add(targetsValues.get(i));
                            }
                        }

                        targetsValues.clear();

                        targetsValues.addAll(newListTargets);

                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;

            }

            input = scanner.nextLine();
        }

        String listTargetsString = targetsValues.toString().replaceAll("[\\[\\],]", "");
        System.out.println(listTargetsString.replaceAll("\\s+", "|"));

    }
}
