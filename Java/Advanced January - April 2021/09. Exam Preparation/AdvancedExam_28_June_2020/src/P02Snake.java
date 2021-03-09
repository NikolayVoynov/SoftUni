import java.util.Scanner;

public class P02Snake {

    static int startRow = 0;
    static int startCol = 0;
    static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[n][n];

        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            territory[r] = line.toCharArray();
            if (line.contains("S")) {
                startRow = r;
                startCol = line.indexOf('S');
            }
        }

        boolean isInTerritory = true;

        while (food < 10 && isInTerritory) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                isInTerritory = moveSnake(startRow - 1, startCol, territory);
            } else if (command.equals("down")) {
                isInTerritory = moveSnake(startRow + 1, startCol, territory);
            } else if (command.equals("left")) {
                isInTerritory = moveSnake(startRow, startCol - 1, territory);
            } else if (command.equals("right")) {
                isInTerritory = moveSnake(startRow, startCol + 1, territory);
            }
        }

        if (food > 9) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }

        System.out.printf("Food eaten: %d%n", food);

        printTerritory(territory);

    }

    private static boolean moveSnake(int newRow, int newCol, char[][] territory) {
        territory[startRow][startCol] = '.';

        if (isOutOfTerritory(newRow, newCol, territory)) {
            return false;
        }

        char symbol = territory[newRow][newCol];

        if (symbol == '*') {
            food++;

        } else if (symbol == 'B') {
            territory[newRow][newCol] = '.';
            int[] secondBurrowLocation = findSecondBurrow(territory);
            newRow = secondBurrowLocation[0];
            newCol = secondBurrowLocation[1];
        }

        territory[newRow][newCol] = 'S';
        startRow = newRow;
        startCol = newCol;

        return true;
    }

    private static int[] findSecondBurrow(char[][] territory) {
        int[] result = null;

        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                if (territory[row][col] == 'B') {
                    result = new int[]{row, col};
                    break;
                }
            }
            if (result != null) {
                break;
            }
        }

        return result;
    }

    private static boolean isOutOfTerritory(int row, int col, char[][] matrix) {

        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printTerritory(char[][] territory) {
        for (int r = 0; r < territory.length; r++) {
            for (int c = 0; c < territory[r].length; c++) {
                System.out.print(territory[r][c]);
            }
            System.out.println();
        }
    }
}
