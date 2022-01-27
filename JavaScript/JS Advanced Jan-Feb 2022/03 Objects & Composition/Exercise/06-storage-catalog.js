function storageCatalog(input) {
    let products = [];

    for (const product of input) {
        let [name, price] = product.split(' : ');

        products.push({name, price})
    }

    products.sort((a,b) => a.name.localeCompare(b.name));

    let firstLetter = '';

    for (const product of products) { 
        if(product.name.charAt(0) == firstLetter) {
            console.log(`  ${product.name}: ${product.price}`);

        } else {
            firstLetter = product.name.charAt(0);
            console.log(product.name.charAt(0));
            console.log(`  ${product.name}: ${product.price}`);
        } 
    }
}

storageCatalog(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
);