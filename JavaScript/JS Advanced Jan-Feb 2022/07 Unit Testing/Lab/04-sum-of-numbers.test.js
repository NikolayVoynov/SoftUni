const expect = require('chai').expect;
const sum = require('./04-sum-of-numbers');

describe('Sum of numbers', () => {
    it('Should return sum of numbers in array', () => {
        let array = [1, 2, 3, 4, 5, 6];
        let expectedSum = 21;

        let actualSum = sum(array);

        expect(actualSum).to.equal(expectedSum);
    });

    it('Should return the sum with negative number in the array', () => {
        let numbers = [1, 2, 3, 4, 5,-6];
        let expectedSum = 9;

        let acualSum = sum(numbers);

        expect(acualSum).to.equal(expectedSum);
    });

    it('Should return the zero when only zeroes are given', () => {
        let numbers = [0, 0, 0, 0];
        let expectedSum = 0;

        let acualSum = sum(numbers);

        expect(acualSum).to.equal(expectedSum);
    });
});