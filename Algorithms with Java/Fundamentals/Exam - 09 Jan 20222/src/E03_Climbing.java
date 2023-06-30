import java.util.*;

public class E03_Climbing {

    public static int[][] matrix;
    public static int[][] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        table = new int[rows][cols];

        table[rows - 1][cols - 1] = matrix[rows - 1][cols - 1];

        for (int r = rows - 2; r >= 0; r--) {
            table[r][cols - 1] = table[r + 1][cols - 1] + matrix[r][cols - 1];
        }

        for (int c = cols - 2; c >= 0; c--) {
            table[rows - 1][c] = table[rows - 1][c + 1] + matrix[rows - 1][c];
        }

        for (int r = rows - 2; r >= 0; r--) {
            for (int c = cols - 2; c >= 0; c--) {
                table[r][c] = Math.max(matrix[r][c] + table[r + 1][c], matrix[r][c] + table[r][c + 1]);
            }
        }

        int row = 0;
        int col = 0;

        List<Integer> path = new ArrayList<>();

        path.add(matrix[0][0]);

        while (row < rows - 1 || col < cols - 1) {
            int down = -1;
            int right = -1;

            if (row < rows - 1) {
                down = table[row + 1][col];
            }

            if (col < cols - 1) {
                right = table[row][col + 1];
            }

            if (down > right) {
                row++;
            } else {
                col++;
            }

            path.add(matrix[row][col]);
        }

        System.out.println(table[0][0]);

        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();

        for (Integer elem : path) {
            sb.append(elem)
                    .append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}