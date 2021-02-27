import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int divider = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> predicate = element -> element % divider != 0;

        numbers.stream().filter(x -> predicate.test(x)).forEach(x-> System.out.print(x + " "));
    }
}
