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

        printRows(rows);
    }

    private static void printRows(List<StringBuilder> rows) {
        for (StringBuilder row : rows) {
            System.out.println(row);
        }
    }
}
