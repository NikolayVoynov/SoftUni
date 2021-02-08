import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(element -> element % 2 != 0);
        System.out.println(String.format(numbers.toString().replaceAll("[\\[\\]]", "")));

        numbers.sort((a,b) -> a.compareTo(b));
        System.out.println(String.format(numbers.toString().replaceAll("[\\[\\]]", "")));
    }
}
