let { expect } = require('chai');

let { testNumbers } = require('./testNumbers.js');


describe("Tests for numbers", function () {
    describe("Tests for sumNumber", function () {
        it("Should return undefined if num1 not a number", function () {
            expect(testNumbers.sumNumbers('str1', 2)).to.equal(undefined);
        });

        it("Should return undefined if num2 not a number", function () {
            expect(testNumbers.sumNumbers(1, 'str2')).to.equal(undefined);
        });

        it("Should return correct sum if num1 and num2 are negative", function () {
            expect(testNumbers.sumNumbers(-1, -2)).to.equal((-3).toFixed(2));
        });

        it("Should return correct sum if num1 is decimal", function () {
            expect(testNumbers.sumNumbers(1.234, 2)).to.equal((3.234).toFixed(2));
        });
    });

    describe("Tests for numberChecker", function () {
        it("Should throw error if input not a number", function () {
            expect(() => testNumbers.numberChecker('str')).to.throw(Error, 'The input is not a number!');
        });

        it("Should return even message", function () {
            expect(testNumbers.numberChecker(4)).to.equal('The number is even!');
        });

        it("Should return odd message", function () {
            expect(testNumbers.numberChecker(7)).to.equal('The number is odd!');
        });
    });

    describe("Tests for averageSumArray", function () {
        it("Should return correct sum", function () {
            expect(testNumbers.averageSumArray([1, 2, 3])).to.equal(2);
        });
    });

});
