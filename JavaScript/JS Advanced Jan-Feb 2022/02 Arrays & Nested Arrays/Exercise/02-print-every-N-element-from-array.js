function printEveryNthElement(array, step) {
    let output = [];

    for (let i = 0; i < array.length; i += step) {
        output.push(array[i]);
    }

    return output;
}

printEveryNthElement(['5', 
'20', 
'31', 
'4', 
'20'], 
2
)