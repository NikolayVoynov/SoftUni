import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class L06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] boundaries = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int lowerBound = boundaries[0];
        int upperBound = boundaries[1];

        String command = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            numbersList.add(i);
        }


        if (command.equals("odd")) {

            numbersList.stream().filter(e -> e % 2 != 0).forEach(number -> System.out.print(number + " "));

        } else if (command.equals("even")) {

            numbersList.stream().filter(e -> e % 2 == 0).forEach(number -> System.out.print(number + " "));

        }
    }
}
