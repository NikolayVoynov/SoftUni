import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class L02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        if (input.length < 2) {
            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + input[0]);
        } else {
            Function<String, Integer> parsesToInteger = n -> Integer.parseInt(n);
            int sum = 0;

            for (String s : input) {
                sum += parsesToInteger.apply(s);
            }

            System.out.println("Count = " + input.length);
            System.out.println("Sum = " + sum);
        }


    }
}
