function solve(input) {
    input.sort((a, b) => a - b);
    let result = [];

    if (input.length % 2 != 0) {
        let middle = Math.floor(input.length / 2);
        result = input.slice(middle);
    } else {
        let middle = (input.length / 2);
        result = input.slice(middle);
    }

    return result;
}

solve([3, 19, 14, 7, 2, 19, 6]);