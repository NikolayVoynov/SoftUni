function solve(n, k) {
    let output = [];

    for (let i = 0; i < n; i++) {
        let newElement = null;

        if (output.length == 0) {
            newElement = 1;
        } else {
            if (i - k < 0) {
                for (let j = i - 1; j >= 0; j--) {
                    newElement += output[j];
                }
            } else {
                for (let j = i - 1; j >= i - k; j--) {
                    newElement += output[j];
                }
            }
        }
        output.push(newElement);
    }

    return output;
}

solve(8, 2);