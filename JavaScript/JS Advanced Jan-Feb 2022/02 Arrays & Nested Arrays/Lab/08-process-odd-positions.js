function solve(input) {
    let result = input.filter((element, i) => i % 2 !== 0)
    .map(element => element * 2)
    .reverse();

    return result.join(' ');
}