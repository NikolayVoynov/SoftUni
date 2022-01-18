function magicMatrices(matrix) {
    let isMagic = true;
    let magicSum = 0;

    matrix[0].forEach(element => {
        magicSum += element;
    });


    matrix.forEach(array => {
        let currentRowSum = 0;
        array.forEach(element => {
            currentRowSum += element;
        })

        if (currentRowSum !== magicSum) {
            isMagic = false;
        }
    })

    if (isMagic) {
        for (let c = 0; c < matrix[0].length; c++) {
            let currentColumnSum = 0;

            for (let r = 0; r < matrix.length; r++) {
                currentColumnSum += matrix[r][c];
            }

            if (currentColumnSum !== magicSum) {
                isMagic = false;
            }
        }
    }

    console.log(isMagic);

    // return isMagic;
}

magicMatrices([[11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]]   
);