function equalNeighbours(matrix) {
    let equalPairs = 0;

    for (let r = 0; r < matrix.length - 1; r++) {
        for (let c = 1; c < matrix[r].length; c++) {
            if (matrix[r][c] == matrix[r][c - 1]) {
                equalPairs++;
            }

            if (matrix[r][c] == matrix[r + 1][c]) {
                equalPairs++;
            }
        }
    }

    for (let r = 0; r < matrix.length - 1; r++) {
        if (matrix[r][0] == matrix[r + 1][0]) {
            equalPairs++;
        }
    }

    for (let c = 0; c < matrix[matrix.length - 1].length - 1; c++) {
        if (matrix[matrix.length - 1][c] == matrix[matrix.length - 1][c + 1]) {
            equalPairs++;
        }
    }

    return equalPairs;
}