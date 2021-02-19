import java.util.Arrays;
import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int dimension = Integer.parseInt(input[0]);
        String fillPattern = input[1];

        int matrix[][] = fillMatrix(dimension, fillPattern);
        printMatrix(matrix);


    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static int[][] fillMatrix(int dimension, String fillPattern) {
        int[][] matrix = new int[dimension][dimension];
        switch (fillPattern) {
            case "A":
                fillMatrixPatternA(matrix);
                break;
            case "B":
                fillMatrixPatternB(matrix);
                break;
        }
        return matrix;
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int element = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = element;
                    element++;
                }
            } else {
                for (int row = matrix[col].length-1; row >= 0 ; row--) {
                    matrix[row][col] = element;
                    element++;
                }

            }
        }

    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int element = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = element;
                element++;
            }
        }
    }


}
