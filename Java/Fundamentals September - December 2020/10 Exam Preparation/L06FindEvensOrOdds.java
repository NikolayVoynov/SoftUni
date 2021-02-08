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

        for (int i = lowerBound; i <= upperBound; i++) {
            Predicate<Integer> tester = printEvenOrOdd(command, i);
            if (tester == null) {
                return;
            } else {
                System.out.print(tester + " ");
            }
        }


    }

    private static Predicate<Integer> printEvenOrOdd(String command, int i) {
        Predicate<Integer> tester = null;
        switch (command) {
            case "even":
                tester = x -> x % 2 == 0;
                break;
            case "odd":
                tester = x -> x % 2 != 0;
                break;
        }

        return tester;
    }
}
