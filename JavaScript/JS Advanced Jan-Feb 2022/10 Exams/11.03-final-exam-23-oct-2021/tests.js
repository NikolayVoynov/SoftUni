let { expect } = require('chai');
let { library } = require("./library.js");

describe("Testing Library", function () {

    describe("Test calcPriceOfBook", function () {
        it("Should return error when name of book is not string", function () {

            expect(() => library.calcPriceOfBook(123, 1234)).to.throw(Error, 'Invalid input');
        });

        it("Should return error when year of book is not number", function () {

            expect(() => library.calcPriceOfBook('Title', 'Title')).to.throw(Error, 'Invalid input');
        });

        it("Should return message when year > 1980", function () {
            let nameOfBook = 'Title';
            let price = 20;
            let expectMessage = `Price of ${nameOfBook} is ${price.toFixed(2)}`;

            expect(library.calcPriceOfBook('Title', 2000)).to.equal(expectMessage);
        });

        it("Should return message when year = 1980", function () {
            let nameOfBook = 'Title';
            let price = 20
            let total = price - (price * 0.5);
            let expectMessage = `Price of ${nameOfBook} is ${total.toFixed(2)}`;

            expect(library.calcPriceOfBook('Title', 1980)).to.equal(expectMessage);
        });

        it("Should return message when year < 1980", function () {
            let nameOfBook = 'Title';
            let price = 20
            let total = price - (price * 0.5);
            let expectMessage = `Price of ${nameOfBook} is ${total.toFixed(2)}`;

            expect(library.calcPriceOfBook('Title', 1650)).to.equal(expectMessage);
        });
    });

    describe("Test findBook", function () {
        it("Should return error when book array = 0", function () {

            expect(() => library.findBook([], 'Title')).to.throw(Error, 'No books currently available');
        });

        it("Should return message when book is there", function () {

            expect(library.findBook(['Title'], 'Title')).to.equal('We found the book you want.');
        });

        it("Should return message when book is NOT there", function () {

            expect(library.findBook([''], 'Title')).to.equal('The book you are looking for is not here!');
        });
    });

    describe("Test arrangeTheBooks", function () {

        it("Should return error when countBooks is string", function () {

            expect(() => library.arrangeTheBooks('smth')).to.throw(Error, 'Invalid input');
        });

        it("Should return error when countBooks is decimal", function () {

            expect(() => library.arrangeTheBooks(2.5)).to.throw(Error, 'Invalid input');
        });

        it("Should return error when countBooks is NEGATIVE number", function () {

            expect(() => library.arrangeTheBooks(-2)).to.throw(Error, 'Invalid input');
        });

        it("Should return message when have enough available space", function () {

            expect(library.arrangeTheBooks(10)).to.equal('Great job, the books are arranged.');
        });

        it("Should return message when have enough available space exact 40", function () {

            expect(library.arrangeTheBooks(40)).to.equal('Great job, the books are arranged.');
        });

        it("Should return message when NOT enough available space", function () {

            expect(library.arrangeTheBooks(100)).to.equal('Insufficient space, more shelves need to be purchased.');
        });

    });

});
