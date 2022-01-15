function cookingNumbers(startNum, ops1, ops2, ops3, ops4, ops5) {

    let result = Number(startNum);
    let operations = [ops1, ops2, ops3, ops4, ops5];

    for (let i = 0; i < operations.length; i++) {
        let operation = operations[i];

        switch (operation) {
            case 'chop':
                result /= 2;
                break;
            case 'dice':
                result = Math.sqrt(result);
                break;
            case 'spice':
                result += 1;
                break;
            case 'bake':
                result *= 3;
                break;
            case 'fillet':
                result = (result*0.8).toFixed(1);
                break;
        }

        console.log(result);
    }

}


cookingNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');