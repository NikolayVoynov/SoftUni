import java.util.Scanner;

public class L06_QueensPuzzle {
    public static char[][] chessBoard = {
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        findQueenPositions(0);
    }

    private static void findQueenPositions(int row) {
        if (row == 8) {
            printChessBoard();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        chessBoard[row][col] = '-';
    }

    private static void putQueen(int row, int col) {
        chessBoard[row][col] = '*';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < 8; c++) {
            if (c == col) {
                continue;
            }
            if (chessBoard[row][c] == '*') {
                return false;
            }
        }

        for (int r = 0; r < 8; r++) {
            if (r == row) {
                continue;
            }
            if (chessBoard[r][col] == '*') {
                return false;
            }
        }

        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (chessBoard[r--][c--] == '*') {
                return false;
            }
        }

        r = row + 1;
        c = col + 1;

        while (r < 8 && c < 8) {
            if (chessBoard[r++][c++] == '*') {
                return false;
            }
        }

        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < 8) {
            if (chessBoard[r--][c++] == '*') {
                return false;
            }
        }

        r = row + 1;
        c = col - 1;

        while (r < 8 && c >= 0) {
            if (chessBoard[r++][c--] == '*') {
                return false;
            }
        }

        return true;
    }


    public static void printChessBoard() {
        for (char[] rowBoard : chessBoard) {
            for (char field : rowBoard) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
