import java.util.Arrays;
import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int sumDiagonals = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumDiagonals += matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            sumDiagonals -= matrix[i][matrix.length - 1 - i];
        }

        System.out.println(Math.abs(sumDiagonals));
    }
}
