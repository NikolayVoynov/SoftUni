let { expect } = require('chai');

let { numberOperations } = require('./03. Number Operations_Resources.js');

describe("Tests for Number Operations", function () {
    describe("Test powNumber", function () {
        it("Should return power of the given number", function () {
            expect(numberOperations.powNumber(4)).to.equal(16);
        });
    });

    describe("Test numberChecker", function () {
        it("Should throw error if input not a number", function () {
            expect(() => numberOperations.numberChecker('str')).to.throw(Error, 'The input is not a number!');
        });

        it("Should return lower than 100", function () {
            expect(numberOperations.numberChecker(10)).to.equal('The number is lower than 100!');
        });

        it("Should return greater or equal to 100", function () {
            expect(numberOperations.numberChecker(120)).to.equal('The number is greater or equal to 100!');
        });

        it("Should return greater or equal to 100", function () {
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
        });
    });

    describe("Test sumArrays", function () {

        it("Should return correct array when array1 > array2", function () {
            expect(numberOperations.sumArrays([1, 1, 1], [1, 1])).to.deep.equal([2, 2, 1]);
        });

        it("Should return correct array when array1 < array2", function () {
            expect(numberOperations.sumArrays([1, 1], [1, 1, 1])).to.deep.equal([2, 2, 1]);
        });

        it("Should return correct array when array1 = array2", function () {
            expect(numberOperations.sumArrays([1, 1, 1], [1, 1, 1])).to.deep.equal([2, 2, 2]);
        });

    });
});
