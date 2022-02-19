let { expect } = require('chai');
let { dealership } = require('./dealership.js');

describe("Test dealership", function () {
    describe("Tests for newCarCost", function () {

        it("Should return deducted price when oldCar is present in list", function () {
            expect(dealership.newCarCost('Audi A6 4K', 40000)).to.equal(20000);
        });

        it("Should return input price for new car when oldCar is NOT present in list", function () {
            expect(dealership.newCarCost('Mercedes', 40000)).to.equal(40000);
        });
    });

    describe("Tests for carEquipment", function () {

        it("Should return correct array of extras", function () {
            expect(dealership.carEquipment(['heated seats', 'sliding roof', 'sport rims', 'navigation'], [0, 1])).to.deep.equal(['heated seats', 'sliding roof']);
        });
    });

    describe("Tests for carEquipment", function () {

        it("Should return correct array of extras", function () {
            expect(dealership.carEquipment(['heated seats', 'sliding roof', 'sport rims', 'navigation'], [0, 1])).to.deep.equal(['heated seats', 'sliding roof']);
        });
    });

    describe("Tests for euroCategory", function () {

        it("Should return message with discount", function () {
            let price = dealership.newCarCost('Audi A4 B8', 30000);
            let total = price - (price * 0.05)

            expect(dealership.euroCategory(6)).to.equal(`We have added 5% discount to the final price: ${total}.`);
        });

        it("Should return message with discount", function () {
            let price = dealership.newCarCost('Audi A4 B8', 30000);
            let total = price - (price * 0.05)

            expect(dealership.euroCategory(4)).to.equal(`We have added 5% discount to the final price: ${total}.`);
        });

        it("Should return message without discount", function () {
            
            expect(dealership.euroCategory(3)).to.equal(`Your euro category is low, so there is no discount from the final price!`);
        });
    });

});
