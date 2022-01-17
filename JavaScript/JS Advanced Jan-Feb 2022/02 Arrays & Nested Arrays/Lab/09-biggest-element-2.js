function solve(matrix) {
    return matrix.flat().sort((a,b) => b-a)[0];
}