import java.util.Scanner;

public class P02BookWorm {

    static int startRow;
    static int startCol;
    static String string;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        string = scanner.nextLine();
        int N = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[N][N];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                startRow = row;
                startCol = line.indexOf("P");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.equals("up")) {
                movePlayer(startRow - 1, startCol, matrix);
            } else if (command.equals("down")) {
                movePlayer(startRow + 1, startCol, matrix);
            } else if (command.equals("left")) {
                movePlayer(startRow, startCol - 1, matrix);
            } else if (command.equals("right")) {
                movePlayer(startRow, startCol + 1, matrix);
            }


            command = scanner.nextLine();
        }

        System.out.println(string);

        printMatrix(matrix);
    }

    private static void movePlayer(int newRow, int newCol, char[][] matrix) {
        if (isOutOfBounds(newRow, newCol, matrix)) {
            if (string.length() != 0) {
                string = string.substring(0, string.length() - 1);
            }
//            No change in player's position
        } else {
            matrix[startRow][startCol] = '-';
            char symbol = matrix[newRow][newCol];

            if (symbol != '-') {
                string += symbol;
                matrix[newRow][newCol] = 'P';
                startRow = newRow;
                startCol = newCol;
            } else {
                matrix[newRow][newCol] = 'P';
                startRow = newRow;
                startCol = newCol;
            }
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
