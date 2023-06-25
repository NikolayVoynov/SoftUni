import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_TBC {

    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 't') {
                    areas.add(new int[]{r, c});
                    findAreas(r, c);
                }
            }
        }

        System.out.println(areas.size());
    }

    private static void findAreas(int r, int c) {
        if (isOutOfBounds(r, c) || isNotTraversable(r, c)) {
            return;
        }

        matrix[r][c] = 'v';

        findAreas(r, c + 1);
        findAreas(r + 1, c + 1);
        findAreas(r + 1, c);
        findAreas(r + 1, c - 1);
        findAreas(r, c - 1);
        findAreas(r -1, c - 1);
        findAreas(r - 1, c);
        findAreas(r - 1, c + 1);
    }

    private static boolean isNotTraversable(int r, int c) {
        return matrix[r][c] == 'd' || matrix[r][c] == 'v';
    }

    private static boolean isOutOfBounds(int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
