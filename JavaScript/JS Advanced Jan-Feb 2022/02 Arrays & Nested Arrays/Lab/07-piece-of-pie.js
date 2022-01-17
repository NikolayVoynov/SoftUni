function solve(input, start, end) {
    let startIndex = input.indexOf(start);
    let endIndex = input.indexOf(end) + 1;

    let result = input.slice(startIndex, endIndex)

    return result;
}