import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintFillArea {
    public static void main(String[] args) {

        List<StringBuilder> rows = new ArrayList<>(Arrays.asList(
                new StringBuilder(".####......................"),
                new StringBuilder(".#..##.....############...."),
                new StringBuilder(".#...##....#..........#...."),
                new StringBuilder(".###..######..##...#..#...."),
                new StringBuilder("...#..........##...####...."),
                new StringBuilder("...#.......##..#####......."),
                new StringBuilder("...##########......#......."),
                new StringBuilder("...........#########.......")
        ));

        fill(rows, 2, 4, 'o');

        printRows(rows);
    }

    private static void fill(List<StringBuilder> matrix, int row, int col, char fillChar) {
        char oldChar = matrix.get(row).charAt(col);
        matrix.get(row).setCharAt(col, fillChar);

        if (matrix.get(row).charAt(col - 1) == oldChar) {
            fill(matrix, row, col - 1, fillChar);
        }

        if (matrix.get(row).charAt(col + 1) == oldChar) {
            fill(matrix, row, col + 1, fillChar);
        }

        if (matrix.get(row - 1).charAt(col) == oldChar) {
            fill(matrix, row - 1, col, fillChar);
        }

        if (matrix.get(row + 1).charAt(col) == oldChar) {
            fill(matrix, row + 1, col, fillChar);
        }
    }

    private static void printRows(List<StringBuilder> rows) {
        for (StringBuilder row : rows) {
            System.out.println(row.toString());
        }
    }
}
