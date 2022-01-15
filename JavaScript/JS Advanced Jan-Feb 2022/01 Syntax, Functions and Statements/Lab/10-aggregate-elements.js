function aggregateElements(array) {

    let sum;
    let sumElementReversed;
    let concat;

    array.forEach(element => {

        sum += element;
        sumElementReversed += 1/element;
        concat += String(element);
    });

    console.log(sum);
    console.log(sumElementReversed);
    console.log(concat);

}

aggregateElements([1, 2, 3]);