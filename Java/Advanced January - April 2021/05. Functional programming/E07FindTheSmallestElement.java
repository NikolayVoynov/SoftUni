import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> rightMostIndexOfSmallest =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        System.out.println(rightMostIndexOfSmallest.apply(numbers));
    }
}
