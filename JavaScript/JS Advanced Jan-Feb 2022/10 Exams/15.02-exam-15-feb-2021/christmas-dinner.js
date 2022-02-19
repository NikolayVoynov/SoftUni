class ChristmasDinner {
    constructor(budget) {
        this.budget = budget;
        this.dishes = [];
        this.products = [];
        this.guests = {};
    }

    get budget() {
        return this._budget;
    }


    set budget(num) {
        if (num < 0) {
            throw new Error('The budget cannot be a negative number');
        }

        this._budget = num;
    }

    shopping(productArr) {
        let typeProduct = productArr[0];
        let priceProduct = Number(productArr[1]);

        if (priceProduct > this.budget) {
            throw new Error('Not enough money to buy this product');

        } else {
            this.products.push(typeProduct);
            this.budget -= priceProduct;
            return `You have successfully bought ${typeProduct}!`;
        }
    }

    recipes(recipe) {

        let allProductsArePresent = true;

        for (const productReq of recipe.productsList) {

            if (!this.products.includes(productReq)) {
                allProductsArePresent = false;

                throw new Error('We do not have this product');
            }

        }

        if (allProductsArePresent) {
            this.dishes.push(recipe);

            return `${recipe.recipeName} has been successfully cooked!`;
        }

    }

    inviteGuests(name, dish) {

        let found = false;

        for (let dishObj of this.dishes) {

            if (dishObj.recipeName == dish) {
                found = true;
            }

        }

        if (!found) {
            throw new Error('We do not have this dish');
        } else if (this.guests[name]) {

            throw new Error('This guest has already been invited');
        } else {
            this.guests[name] = dish;
    
            return `You have successfully invited ${name}!`;
        }
    }

    showAttendance() {
        let allGuests = [];

        for (let guest in this.guests) {

            let dish = this.guests[guest];
            let requiredDish = this.dishes.find(x => x.recipeName == dish);
            let products = requiredDish.productsList;
            let row = `${guest.guestName} will eat ${dish}, which consists of ${products.join(', ')}`;

            allGuests.push(row);
        }

        return allGuests.join('\n');
    }
}



let dinner = new ChristmasDinner(300);

dinner.shopping(['Salt', 1]);
dinner.shopping(['Beans', 3]);
dinner.shopping(['Cabbage', 4]);
dinner.shopping(['Rice', 2]);
dinner.shopping(['Savory', 1]);
dinner.shopping(['Peppers', 1]);
dinner.shopping(['Fruits', 40]);
dinner.shopping(['Honey', 10]);

dinner.recipes({
    recipeName: 'Oshav',
    productsList: ['Fruits', 'Honey']
});
dinner.recipes({
    recipeName: 'Folded cabbage leaves filled with rice',
    productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
});
dinner.recipes({
    recipeName: 'Peppers filled with beans',
    productsList: ['Beans', 'Peppers', 'Salt']
});

dinner.inviteGuests('Ivan', 'Oshav');
dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
dinner.inviteGuests('Georgi', 'Peppers filled with beans');

console.log(dinner.showAttendance());
