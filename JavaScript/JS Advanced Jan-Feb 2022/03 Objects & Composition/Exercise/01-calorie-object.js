function createCalorieObject(input) {

    let calorieObject = {}

    for (let i = 0; i < input.length; i += 2) {
        calorieObject[input[i]] = Number(input[i + 1]);
    }

    console.log(calorieObject);
}

createCalorieObject(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);