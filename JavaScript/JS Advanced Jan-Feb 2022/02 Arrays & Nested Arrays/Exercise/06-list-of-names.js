function listNames(array) {
    let sortedArray = array.sort(function (a, b) {
        return a.localeCompare(b);
    });
    let position = 1;

    sortedArray.forEach(element => {
        console.log(`${position}.${element}`);
        position++;
    });
}

listNames(["John", "Bob", "Christina", "Ema"]);