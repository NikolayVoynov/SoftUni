import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int sumMax = Integer.MIN_VALUE;
        int rowMax = 0;
        int colMax = 0;

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int sumCurrent = calculateSumMatrix(matrix, row, col);

                if (sumCurrent > sumMax) {
                    sumMax = sumCurrent;
                    rowMax = row;
                    colMax = col;
                }
            }
        }

        System.out.println(String.format("Sum = %d", sumMax));
        printMatrixWithHighSum(matrix, rowMax, colMax);
    }

    private static void printMatrixWithHighSum(int[][] matrix, int rowMax, int colMax) {
        for (int row = rowMax; row <= rowMax + 2; row++) {
            for (int col = colMax; col <= colMax + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSumMatrix(int[][] matrix, int currentRow, int currentCol) {
        int sumCurrent = 0;

        for (int row = currentRow; row <= currentRow + 2; row++) {
            for (int col = currentCol; col <= currentCol + 2; col++) {
                sumCurrent += matrix[row][col];
            }
        }

        return sumCurrent;
    }
}
