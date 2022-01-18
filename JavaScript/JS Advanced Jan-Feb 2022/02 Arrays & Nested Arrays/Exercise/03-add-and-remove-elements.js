function addRemoveElements(array) {
    let output = [];
    let element = 0;

    for (let i = 0; i < array.length; i++) {
        let command = array[i];
        element += 1;

        switch (command) {
            case 'add':
                output.push(element);
                break;
            case 'remove':
                output.pop();
                break;
        }
    }

    if (output.length !== 0) {
        console.log(output.join('\n'));
    } else {
        console.log('Empty');
    }
}

addRemoveElements(['add',
    'add',
    'remove',
    'add',
    'add']
)