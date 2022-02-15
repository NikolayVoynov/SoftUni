class Restaurant {
    constructor(budget) {
        this.budgetMoney = budget;
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {

        for (const line of products) {
            let lineArr = line.split(' ');
            let productName = lineArr[0];
            let productQuantity = Number(lineArr[1]);
            let productTotalPrice = Number(lineArr[2]);

            if (productTotalPrice <= this.budgetMoney) {

                if (!this.stockProducts[productName]) {
                    this.stockProducts[productName] = productQuantity;
                    this.budgetMoney -= productTotalPrice;
                } else {
                    this.stockProducts.productName += productQuantity;
                }

                this.history.push(`Successfully loaded ${productQuantity} ${productName}`);

            } else {
                this.history.push(`There was not enough money to load ${productQuantity} ${productName}`);
            }
        }

        return this.history.join('\n');
    };

    addToMenu(meal, neededProducts, price) {

        if (!this.menu[meal]) {
            this.menu[meal] = { neededProducts, price }

            let numberMeals = Object.keys(this.menu).length;

            if (numberMeals == 1) {
                return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`;

            } else if (numberMeals == 0 || numberMeals >= 2) {
                return `Great idea! Now with the ${meal} we have ${numberMeals} meals in the menu, other ideas?`;
            }

        } else {
            return `The ${meal} is already in the our menu, try something different.`;
        }
    };

    showTheMenu() {
        let numberMeals = Object.keys(this.menu).length;

        if (numberMeals == 0) {
            return `Our menu is not ready yet, please come later...`;
        } else {

            let allMeals = [];

            for (const key in this.menu) {
                allMeals.push(`${key} - $ ${this.menu[key].price}`);
            }

            return allMeals.join('\n');
        }
    };

    makeTheOrder(meal) {

        if (!this.menu[meal]) {
            return `There is not ${meal} yet in our menu, do you want to order something else?`
        } else {
            let productsForMeal = this.menu[meal].neededProducts;
            let haveNeeded = true;

            for (const productData of productsForMeal) {
                let array = productData.split(' ');
                let product = array[0];
                let quantity = array[1];

                if (!this.stockProducts[product] || this.stockProducts[product] < quantity) {
                    haveNeeded = false;
                }

            }

            if (haveNeeded) {
                let mealPrice = this.menu[meal].price;
                this.budgetMoney += mealPrice;

                for (const productData of productsForMeal) {
                    let array = productData.split(' ');
                    let product = array[0];
                    let quantity = Number(array[1]);

                    this.stockProducts[product] -= quantity;
                }

                return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${mealPrice}.`;
            } else {
                return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
            }
        }
    };
}

