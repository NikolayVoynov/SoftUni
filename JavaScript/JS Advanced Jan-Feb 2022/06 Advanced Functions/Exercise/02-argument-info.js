function argumentInfo() {
    let data = {};

    Array.from(arguments).forEach((argument) => {
        let type = typeof argument;
        console.log(`${type}: ${argument}`);

        if (!data[type]) {
            data[type] = 0;
        }
        data[type]++;
    })

    Object.keys(data)
        .sort((a, b) => { data[b] - data[a] })
        .forEach(key => console.log(`${key} = ${data[key]}`));

}

argumentInfo('cat', 42, function () { console.log('Hello world!'); });