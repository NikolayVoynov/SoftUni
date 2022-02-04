function add(number) {

    let sum = 0;

    function innerFunction(num) {
        sum += num;

        return innerFunction;
    }

    innerFunction.toString = () => {
        return sum;
    }

    return innerFunction(number);
}

console.log(add(1)(6)(-3).toString());