function drawStarRectangle(input) {

    let typeInput = typeof (input);
    let size;

    if (typeInput === "number") {
        size = Number(input);

        for (let i = 1; i <= size; i++) {
            console.log("*".repeat(size)).join(" ");
        }

    } else {
        size = 5;

        for (let i = 1; i <= size; i++) {
            console.log("*".repeat(size)).join(" ");
        }

    }
}

drawStarRectangle(7);