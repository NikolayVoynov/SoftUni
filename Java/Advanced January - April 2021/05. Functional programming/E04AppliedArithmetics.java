import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> addOne = array -> Arrays.stream(array).map(element -> element + 1).toArray();
        Function<int[], int[]> multiplyByTwo = array -> Arrays.stream(array).map(element -> element * 2).toArray();
        Function<int[], int[]> subtractOne = array -> Arrays.stream(array).map(element -> element - 1).toArray();
        Consumer<int[]> printArray = array -> System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));

        String command = "";
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                    printArray.accept(numbers);
                    break;
            }
        }


    }
}
