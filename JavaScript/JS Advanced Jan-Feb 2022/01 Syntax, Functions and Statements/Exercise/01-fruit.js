function moneyForFruit(fruit, grams, price) {
    let typeFruit = fruit;
    let fruitInKg = grams / 1000;
    let pricePerKg = price;

    let finalPrice = fruitInKg * pricePerKg;

    console.log(`I need $${finalPrice.toFixed(2)} to buy ${fruitInKg.toFixed(2)} kilograms ${typeFruit}.`);
}

moneyForFruit('apple', 1563, 2.35);