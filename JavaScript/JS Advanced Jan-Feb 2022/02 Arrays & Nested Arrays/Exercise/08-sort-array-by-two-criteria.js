function sortByTwoCriteria(array) {

    let sortedArray = array.sort(function (a, b) {
        let result = a.length - b.length;
        if (result === 0) {
            result = a.localeCompare(b);
        }
        return result;

    });

    console.log(sortedArray.join('\n'));

}

sortByTwoCriteria(['test',
    'Deny',
    'omen',
    'Default']
)