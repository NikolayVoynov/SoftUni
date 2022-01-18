function sortNumbers(array) {
    let sorted = array.sort((a, b) => a - b);
    let result = [];

    while (sorted.length !== 0) {
        let small = sorted.shift();
        result.push(small);

        if (sorted.length !== 0) {
            let big = sorted.pop();
            result.push(big);
        }
    }

    return result;
}