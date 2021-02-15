import java.util.*;
import java.util.stream.Collectors;

public class E01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (Integer number : numbers) {
            stack.push(number);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
