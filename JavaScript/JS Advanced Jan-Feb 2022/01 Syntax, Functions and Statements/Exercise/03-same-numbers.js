function solveNumber(number) {
    let numberString = String(number);
    let firstDigit = Number(numberString[0]);
    let isSame = true;
    let sumDigits = 0;

    for(let i = 0; i < numberString.length; i++) {
        let digit = Number(numberString[i]);

        if(digit != firstDigit) {
            isSame = false;
        }

        sumDigits += digit;        
    }

    console.log(isSame);
    console.log(sumDigits);
}


solveNumber(45);