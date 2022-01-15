function sumNumbers(first, last) {
    let num1 = Number(first);
    let num2 = Number(last);

    let result = 0;
    
    for(let i = num1; i <= num2; i++) {
        result += i;
    }

    console.log(result);
}

sumNumbers('1', '5');
