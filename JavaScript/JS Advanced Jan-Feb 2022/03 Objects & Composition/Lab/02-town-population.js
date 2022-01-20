function townPopulation(array) {

    const towns = {};

    array.forEach(element => {
        let town = element.split(' <-> ');
        let name = town[0];
        let population = Number(town[1]);

        if (towns[name] != undefined) {
            towns[name] += population;
        } else {
            towns[name] = population;
        }
    });


    for (let name in towns) {
        console.log(`${name} : ${towns[name]}`);
    }
}


townPopulation(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
);