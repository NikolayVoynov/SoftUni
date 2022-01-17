function solve(matrix) {
    let biggestElement = matrix[0][0];

    for (let row of matrix) {
        for (let col of row) {
            let current = Number(col);
            if (current > biggestElement) {
                biggestElement = current;
            }
        }
    }
    return biggestElement;
}

solve([[3, 5, 7, 12],
[-1, 4, 33, 2],
[8, 3, 0, 4]]);