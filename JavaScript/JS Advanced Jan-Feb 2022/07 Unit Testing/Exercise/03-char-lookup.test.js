const { assert } = require('chai');
const lookupChar = require('./03-char-lookup');

describe('Check character', () => {

    it('Should return correct character', () => {
        assert(lookupChar('nikolay', 0) === 'n');
    });

    it('Should return correct character', () => {
        assert(lookupChar('nikolay', 1) === 'i');
    });

    it('Should return incorrect index when index less than zero', () => {
        assert(lookupChar('nikolay', -1) === 'Incorrect index');
    });

    it('Should return incorrect index when index more than length', () => {
        assert(lookupChar('nikolay', 20) === 'Incorrect index');
    });

    it('Should return incorrect index when index equal to length', () => {
        assert(lookupChar('nikolay', 7) === 'Incorrect index');
    });

    it('Should return incorrect index when index equal to 0 and empty string', () => {
        assert(lookupChar('', 0) === 'Incorrect index');
    });

    it('Should return undefined when input is not string', () => {
        assert(lookupChar(10, 0) === undefined);
    });

    it('Should return undefined when index is not number', () => {
        assert(lookupChar('nikolay', 'smth') === undefined);
    });

    it('Should return undefined when index is not integer', () => {
        assert(lookupChar('nikolay', 8.5) === undefined);
    });
});