const expect = require('chai').expect;
const isOddOrEven = require('./02-even-or-odd');

describe('Is it Odd or Even number', () => {
    it('Should return undefined when input is array', () => {
        let input = [];
        let expected = undefined;

        let actual = isOddOrEven(input);

        expect(actual).to.equal(expected);
    });

    it('Should return undefined when input is object', () => {
        let input = {};
        let expected = undefined;

        let actual = isOddOrEven(input);

        expect(actual).to.equal(expected);
    });

    it('Should return undefined when input is number', () => {
        let input = 10;
        let expected = undefined;

        let actual = isOddOrEven(input);

        expect(actual).to.equal(expected);
    });

    it('Should return even when input is even string', () => {
        let input = 'monika';
        let expected = 'even';

        let actual = isOddOrEven(input);

        expect(actual).to.equal(expected);
    });

    it('Should return even when input is even string', () => {
        let input = 'nikolay';
        let expected = 'odd';

        let actual = isOddOrEven(input);

        expect(actual).to.equal(expected);
    });

});