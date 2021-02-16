import java.util.Arrays;
import java.util.Scanner;

public class L04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int dimension : dimensions) {
            System.out.println(dimension);
        }

        int rows = dimensions[0];
        int cols = dimensions[1];

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            int[] inputRow = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int sumRowElements = Arrays.stream(inputRow).sum();
            sum += sumRowElements;
        }

        System.out.println(sum);
    }
}
