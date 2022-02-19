let { expect } = require('chai');
let { flowerShop } = require('./flowerShop.js');



describe("Test flowrShop", function () {
    describe("Test calcPriceOfFlowers", function () {
        it("Should return error when invalid flower type", function () {
            expect(() => flowerShop.calcPriceOfFlowers(200, 300, 30)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when invalid price type", function () {
            expect(() => flowerShop.calcPriceOfFlowers('rose', 'str', 30)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when invalid quantity type", function () {
            expect(() => flowerShop.calcPriceOfFlowers('rose', 30, 'str')).to.throw(Error, 'Invalid input!');
        });

        it("Should return result", function () {
            let price = 10;
            let quantity = 10;
            let flower = 'rose';
            let result = price * quantity;

            expect(flowerShop.calcPriceOfFlowers('rose', 10, 10)).to.equal(`You need $${result.toFixed(2)} to buy ${flower}!`)
        });
    });


    describe("Test checkFlowersAvailable", function () {
        it("Should return available message", function () {
            let flower = "Rose";
            expect(flowerShop.checkFlowersAvailable("Rose", ["Rose", "Lily", "Orchid"])).to.equal(`The ${flower} are available!`)
        });

        it("Should return sold message1", function () {
            let flower = "Rose";
            expect(flowerShop.checkFlowersAvailable("Rose", ["Lily", "Orchid"])).to.equal(`The ${flower} are sold! You need to purchase more!`)
        });

        it("Should return sold message2", function () {
            let flower = "Rose";
            expect(flowerShop.checkFlowersAvailable("Rose", [])).to.equal(`The ${flower} are sold! You need to purchase more!`)
        });
    });

    describe("Test sellFlowers", function () {
        it("Should return error when invalid gardenArray type", function () {
            expect(() => flowerShop.sellFlowers({}, 1)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when invalid space type", function () {
            expect(() => flowerShop.sellFlowers(["Rose", "Lily", "Orchid"], 1.7)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when space < 0", function () {
            expect(() => flowerShop.sellFlowers(["Rose", "Lily", "Orchid"], -1)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when space > arr length", function () {
            let arr = ["Rose", "Lily", "Orchid"];

            expect(() => flowerShop.sellFlowers(arr, 7)).to.throw(Error, 'Invalid input!');
        });

        it("Should return error when space = arr length", function () {
            let arr = ["Rose", "Lily", "Orchid"];

            expect(() => flowerShop.sellFlowers(arr, 3)).to.throw(Error, 'Invalid input!');
        });

        it("Should return string joined by /", function () {
            
            expect(flowerShop.sellFlowers(["Rose", "Lily", "Orchid"], 0)).to.equal('Lily / Orchid');
        });


    });
});
