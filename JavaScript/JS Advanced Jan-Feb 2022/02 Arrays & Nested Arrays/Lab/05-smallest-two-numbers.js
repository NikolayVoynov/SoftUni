function solve(input) {
    input.sort((a, b) => a - b);
    let result = input.slice(0,2);

    console.log(result.join(' '));
}

solve([3, 0, 10, 4, 7, 3]);