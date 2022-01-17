function sumFirstLast(input) {
    let first = Number(input.shift());
    let last = Number(input.pop());

    let result = first + last;

    return result;
}


sumFirstLast(['20', '30', '40']);