package P05JediGalaxy;

public class Field {
    int[][] matrix;

    public Field(int[][] matrix) {
        this.matrix = matrix;
        this.setFieldValues();
    }

    private void setFieldValues() {
        int cellValue = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = cellValue++;
            }
        }
    }

    public int getLength() {
        return this.matrix.length;
    }

    public int getDimensionLength(int dimension) {
        return matrix[dimension].length;
    }

    public void setCell(int row, int col, int newValueCell) {
        this.matrix[row][col] = newValueCell;
    }

    public int getCell(int row, int col){
        return this.matrix[row][col];
    }
}
