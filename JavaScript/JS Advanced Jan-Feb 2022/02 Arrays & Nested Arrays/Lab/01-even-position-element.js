function evenPositionElements(input) {
    let result = '';
    for (let i = 0; i < input.length; i += 2) {
        result += (input[i] + ' ');
    }

    console.log(result);
}

evenPositionElements(['20', '30', '40', '50', '60']);