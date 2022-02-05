function subSum(array, start, end) {
    if (!Array.isArray(array)) {
        return NaN;
    }

    let startIndex = Math.max(start, 0);
    let endIndex = Math.min(end, array.length - 1);

    let numbers = array.slice(startIndex, endIndex + 1);
    let sumNumbers = numbers.reduce((a, x) => a += Number(x), 0);

    return sumNumbers;
}