import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        String input = scanner.nextLine();

        String regex = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("END")) {
            boolean validInput = true;
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));

                boolean inputIndexes = row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
                        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;

                if (inputIndexes) {
                    int current = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = current;

                    printCurrentMatrix(matrix);

                } else {
                    validInput = false;
                }

            } else {
                validInput = false;
            }

            if (!validInput) {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }

    }

    public static void printCurrentMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
