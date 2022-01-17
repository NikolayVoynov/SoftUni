function sumDiagonal(matrix) {
    let firstDiagonal = 0;
    let secondDiagonal = 0;

    let firstStartIndex = 0;
    let secondStartIndex = matrix[0].length - 1;

    matrix.forEach(rowArray => {
        firstDiagonal += rowArray[firstStartIndex++];
        secondDiagonal += rowArray[secondStartIndex--]
    });

    console.log(firstDiagonal + ' ' + secondDiagonal);
}

sumDiagonal([[20, 40],
[10, 60]]
);