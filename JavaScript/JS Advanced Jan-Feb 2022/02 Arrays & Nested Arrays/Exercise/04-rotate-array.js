function rotateArray(array, rotations) {
    for(let i = 0; i < rotations; i++) {
        let removed = array.pop();
        array.unshift(removed);
    }

    console.log(array.join(' '));
}

rotateArray(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
)