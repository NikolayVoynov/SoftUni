function sumAverageLength(str1,str2,str3) {
    let sumLength = str1.length + str2.length + str3.length;
    let averageLength = Math.floor(sumLength / 3);

    console.log(sumLength);
    console.log(averageLength);
}

sumAverageLength('chocolate', 'ice cream', 'cake')