import java.util.*;

public class L03_MoveDownRight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] elements = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            elements[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] table = new int[rows][cols];

        table[0][0] = elements[0][0];

        for (int c = 1; c < cols; c++) {
            table[0][c] = table[0][c - 1] + elements[0][c];
        }

        for (int r = 1; r < rows; r++) {
            table[r][0] = table[r - 1][0] + elements[r][0];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                table[r][c] = Math.max(elements[r][c] + table[r - 1][c], elements[r][c] + table[r][c - 1]);
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(row, col));

        while (row > 0 || col > 0) {
            int top = -1;
            int left = -1;

            if (row > 0) {
                top = table[row - 1][col];
            }

            if (col > 0) {
                left = table[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);

        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
