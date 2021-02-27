import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[],Integer> findSmallestNumber = numbers -> Arrays.stream(numbers).min().getAsInt();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSmallestNumber.apply(numbers));
    }
}
