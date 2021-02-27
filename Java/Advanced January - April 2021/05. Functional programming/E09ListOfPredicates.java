import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        Set<Integer> dividers =
                Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                        .boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = number -> {
            for (Integer divider : dividers) {
                if (number % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= range; i++) {
            boolean numberIsDivisible = isDivisible.test(i);
            if (numberIsDivisible) {
                System.out.print(i + " ");
            }
        }
    }
}
