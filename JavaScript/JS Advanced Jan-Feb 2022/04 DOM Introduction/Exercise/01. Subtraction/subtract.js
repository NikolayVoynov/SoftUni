function subtract() {
    let firstNumber = document.getElementById("firstNumber").value;
    let firstAsNumber = Number(firstNumber);
    let secondNumber = document.getElementById("secondNumber").value;
    let secondAsNumber = Number(secondNumber);

    let result = firstAsNumber - secondAsNumber;

    document.getElementById("result").textContent = result;
}