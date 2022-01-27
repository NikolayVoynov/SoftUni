function productsLowestPriceByCity(input) {

    let products = [];

    for (let i = 0; i < input.length; i++) {
        let [town, product, price] = input[i].split(' | ');
        

        if (products.filter(x => x.product === product).length > 0) {

            let productObject = products.find(x => x.product === product);

            if (Number(price) < productObject.price) {
                productObject.price = Number(price);
                productObject.town = town;
            }

        } else {
            let object = { product, price : Number(price), town };
            products.push(object);
        };

    };

    for (const product of products) {
        console.log(`${product.product} -> ${product.price} (${product.town})`);
        
    }
}

productsLowestPriceByCity(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']
);