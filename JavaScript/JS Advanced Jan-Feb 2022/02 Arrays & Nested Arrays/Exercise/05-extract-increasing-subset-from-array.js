function extractIncreasingSubset(array) {
    let biggest = array[0];
    let result = [];

    for (let i = 0; i < array.length; i++) {
        if (array[i] >= biggest) {
            biggest = array[i];
            result.push(biggest);
        }
    }

    return result;
}