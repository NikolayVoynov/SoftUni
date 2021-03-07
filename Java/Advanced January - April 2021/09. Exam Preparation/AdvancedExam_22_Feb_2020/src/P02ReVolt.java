import java.util.Scanner;

public class P02ReVolt {

    static int startRow;
    static int startCol;
    static String command;
    static boolean finished;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[N][N];

        for (int row = 0; row < N; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("f")) {
                startRow = row;
                startCol = line.indexOf("f");
            }
        }

        finished = false;

        for (int i = 0; i < n; i++) {
            command = scanner.nextLine();
            if (command.equals("up")) {
                movePlayer(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                movePlayer(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                movePlayer(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                movePlayer(startRow, startCol + 1, matrix);
            }

            if (finished) {
                break;
            }
        }

        if (finished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void movePlayer(int newRow, int newCol, char[][] matrix) {
        matrix[startRow][startCol] = '-';

        if (isOutOfBounds(newRow, newCol, matrix)) {

            if (command.equals("left")) {
                startCol = matrix[startRow].length - 1;
                checkForTrapBonusFinal(startRow, startCol, matrix);
            } else if (command.equals("right")) {
                startCol = 0;
                checkForTrapBonusFinal(startRow, startCol, matrix);
            } else if (command.equals("up")) {
                startRow = matrix.length - 1;
                checkForTrapBonusFinal(startRow, startCol, matrix);
            } else if (command.equals("down")) {
                startRow = 0;
                checkForTrapBonusFinal(startRow, startCol, matrix);
            }
        } else {
            char symbol = matrix[newRow][newCol];

            if (symbol == 'F') {
                matrix[newRow][newCol] = 'f';
                finished = true;
            } else if (symbol == 'B') {
                nextMoveBonus(newRow, newCol, command, matrix);
            } else if (symbol == 'T') {
                nextMoveTrap(newRow, newCol, command, matrix);
            } else {
                matrix[newRow][newCol] = 'f';
                startRow = newRow;
                startCol = newCol;
            }
        }
    }

    private static void checkForTrapBonusFinal(int row, int col, char[][] matrix) {
        if (matrix[row][col] == 'F') {
            matrix[row][col] = 'f';
            startRow = row;
            startCol = col;
            finished = true;
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '-';
            nextMoveBonus(row, col, command, matrix);
        } else if (matrix[row][col] == 'T') {
            matrix[row][col] = '-';
            nextMoveTrap(row, col, command, matrix);
        }
    }

    private static void nextMoveTrap(int row, int col, String command, char[][] matrix) {

//        trap moves player backwards/opposite

        if (command.equals("up")) {
            startRow = row + 1;
            startCol = col;
        } else if (command.equals("down")) {
            startRow = row - 1;
            startCol = col;
        } else if (command.equals("left")) {
            startRow = row;
            startCol = col + 1;
        } else if (command.equals("right")) {
            startRow = row;
            startCol = col - 1;
        }

        if (matrix[startRow][startCol] == 'F') {
            matrix[startRow][startCol] = 'f';
            finished = true;
        } else {
            matrix[startRow][startCol] = 'f';
        }
    }

    private static void nextMoveBonus(int row, int col, String command, char[][] matrix) {
        if (command.equals("up")) {
            startRow = row - 1;
            startCol = col;
        } else if (command.equals("down")) {
            startRow = row + 1;
            startCol = col;
        } else if (command.equals("left")) {
            startRow = row;
            startCol = col - 1;
        } else if (command.equals("right")) {
            startRow = row;
            startCol = col + 1;
        }

        if (matrix[startRow][startCol] == 'F') {
            matrix[startRow][startCol] = 'f';
            finished = true;
        } else {
            matrix[startRow][startCol] = 'f';
        }

    }


    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
