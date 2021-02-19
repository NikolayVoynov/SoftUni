import java.util.ArrayDeque;
import java.util.Scanner;

public class E06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')'))) % 360;

        input = scanner.nextLine();
        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        int maxLength = 0;

        while (!input.equals("END")) {
            inputQueue.offer(input);

            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }

        char[][] matrix = new char[inputQueue.size()][maxLength];

        for (int i = 0; i < matrix.length; i++) {
            String row = inputQueue.poll();

            for (int j = 0; j < maxLength; j++) {
                if (row != null && j < row.length()) {
                    matrix[i][j] = row.charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        if (degrees == 0) {
            rotation0(matrix);
        } else if (degrees == 90) {
            rotation90(matrix);
        } else if (degrees == 180) {
            rotation180(matrix);
        } else if (degrees == 270) {
            rotation270(matrix);
        }
    }

    private static void rotation0(char[][] matrix) {
        for (char[] row : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }

    private static void rotation90(char[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotation180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotation270(char[][] matrix) {
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            for (char[] row : matrix) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }
}
