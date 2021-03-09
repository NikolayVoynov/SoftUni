import java.util.Arrays;
import java.util.Scanner;

public class P02Bomb {

    static int startRow;
    static int startCol;
    static int bombCount;
    static int foundBombs;
    static boolean endRoutGame;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[n][n];

        bombCount = 0;

        for (int row = 0; row < field.length; row++) {
            String[] rowMatrix = scanner.nextLine().split("\\s+");
            String line = "";
            for (String element : rowMatrix) {
                line += element;
            }

            field[row] = line.toCharArray();

            if (line.contains("s")) {
                startRow = row;
                startCol = line.indexOf("s");
            }

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'B') {
                    bombCount++;
                }
            }

        }

        endRoutGame = false;
        boolean allBombsHaveBeenFound = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("up")) {
                moveSapper(startRow - 1, startCol, field);
            } else if (command.equals("down")) {
                moveSapper(startRow + 1, startCol, field);
            } else if (command.equals("left")) {
                moveSapper(startRow, startCol - 1, field);
            } else if (command.equals("right")) {
                moveSapper(startRow, startCol + 1, field);
            }

            if (endRoutGame) {
                break;
            }

            if (bombCount == foundBombs) {
                allBombsHaveBeenFound = true;
                break;
            }

        }

        if (allBombsHaveBeenFound) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endRoutGame) {
            System.out.println(String.format("END! %d bombs left on the field", bombCount - foundBombs));
        } else {
            System.out.println(String.format("%d bombs left on the field. Sapper position: (%d,%d)"
                    , bombCount - foundBombs, startRow, startCol));
        }


//        printField(field);

    }

    private static void moveSapper(int newRow, int newCol, char[][] field) {

        if (isInBounds(newRow, newCol, field)) {

            char symbol = field[newRow][newCol];

            if (symbol == 'B') {
                field[newRow][newCol] = '+';
                foundBombs++;
                System.out.println("You found a bomb!");
                startRow = newRow;
                startCol = newCol;

            } else if (symbol == 'e') {
                endRoutGame = true;
                startRow = newRow;
                startCol = newCol;

            } else {
                startRow = newRow;
                startCol = newCol;
            }


        }

    }

    private static boolean isInBounds(int row, int col, char[][] field) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }

//    private static void printField(char[][] field) {
//        for (int r = 0; r < field.length; r++) {
//            for (int c = 0; c < field[r].length; c++) {
//                System.out.print(field[r][c]);
//            }
//            System.out.println();
//        }
//    }
}
