function autoEngineeringCompany(input) {
    let collection = new Map();

    for (line of input) {
        [carBrand, carModel, producedCars] = line.split(' | ');

        if (!collection.has(carBrand)) {
            collection.set(carBrand, new Map());
        }

        if (!collection.get(carBrand).has(carModel)) {
            collection.get(carBrand).set(carModel, producedCars);
        } else {
            collection.get(carBrand).set(carModel, collection.get(carBrand).get(carModel) + producedCars);
        }
    }

    for (let [carBrand, models] of collection.entries()) {
        console.log(carBrand);

        for (let [carModel, producedCars] of models.entries()) {
            console.log(`###${carModel} -> ${producedCars}`);
        }
    }
}


autoEngineeringCompany(['Audi | Q7 | 1000',
'Audi | Q6 | 100',
'BMW | X5 | 1000',
'BMW | X6 | 100',
'Citroen | C4 | 123',
'Volga | GAZ-24 | 1000000',
'Lada | Niva | 1000000',
'Lada | Jigula | 1000000',
'Citroen | C4 | 22',
'Citroen | C5 | 10']
);