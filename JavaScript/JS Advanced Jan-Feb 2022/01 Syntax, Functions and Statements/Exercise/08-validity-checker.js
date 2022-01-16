function solve(x1, y1, x2, y2) {


    function validation(a1, b1, a2, b2) {

        let underRoot = (a2 - a1) ** 2 + (b2 - b1) ** 2;
        let finalSqrt = Math.sqrt(underRoot);

        let isValid = true;

        if (finalSqrt.toString().includes('.')) {
            isValid = false;
        }

        if (isValid) {
            console.log(`{${a1}, ${b1}} to {${a2}, ${b2}} is valid`);
        } else {
            console.log(`{${a1}, ${b1}} to {${a2}, ${b2}} is invalid`);
        }

    }

    validation(x1, y1, 0, 0);
    validation(x2, y2, 0, 0);
    validation(x1, y1, x2, y2);
}

solve(2, 1, 1, 1);