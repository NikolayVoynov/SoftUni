package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        this.changeChar(this.startRow, this.startCol);
    }

    private void changeChar(Integer row, Integer col) {
        if (isInMatrix(row, col) && this.matrix[row][col] == this.toBeReplaced) {
            this.matrix[row][col] = this.fillChar;

            this.changeChar(row - 1, col);
            this.changeChar(row, col + 1);
            this.changeChar(row + 1, col);
            this.changeChar(row, col - 1);
        }

    }

    private Boolean isInMatrix(Integer row, Integer col) {
        return row >= 0 && row < this.matrix.length
                && col >= 0 && col < this.matrix[0].length;
    }

    public String toOutputString() {
        StringBuilder sb = new StringBuilder();

        for (char[] chars : matrix) {
            for (char currentChar : chars) {
                sb.append(currentChar);
            }

            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
