const { assert } = require('chai');
const mathEnforcer = require('./04-math-enforcer');

describe('Math Enforcer', () => {

    describe('Add Five', () => {

        it('Should return undefined if input is not number', () => {
            assert(mathEnforcer.addFive('something') === undefined);
        });

        it('Should return undefined if input is null', () => {
            assert(mathEnforcer.addFive(null) === undefined);
        });

        it('Should return undefined if input is object', () => {
            assert(mathEnforcer.addFive({}) === undefined);
        });

        it('Should return undefined if input is array', () => {
            assert(mathEnforcer.addFive([]) === undefined);
        });

        it('Should return undefined if input is undefined', () => {
            assert(mathEnforcer.addFive(undefined) === undefined);
        });

        it('Should return right answer if input is positive number', () => {
            assert(mathEnforcer.addFive(10) === 15);
        });

        it('Should return right answer if input is negative number', () => {
            assert(mathEnforcer.addFive(-10) === -5);
        });

        it('Should return right answer if input is decimal number', () => {
            assert(mathEnforcer.addFive(10.5) === 15.5);
        });

    });

    describe('Subtract Ten', () => {

        it('Should return undefined if input is not number', () => {
            assert(mathEnforcer.subtractTen('something') === undefined);
        });

        it('Should return right answer if input is number', () => {
            assert(mathEnforcer.subtractTen(15) === 5);
        });

        it('Should return right answer if input is negative', () => {
            assert(mathEnforcer.subtractTen(-15) === -25);
        });

        it('Should return right answer (negative) if input is less than 10', () => {
            assert(mathEnforcer.subtractTen(5) === -5);
        });

        it('Should return right answer if input is decimal number', () => {
            assert(mathEnforcer.subtractTen(10.5) === 0.5);
        });

    });

    describe('Sum', () => {

        it('Should return undefined if input1 is not number', () => {
            assert(mathEnforcer.sum('something', 10) === undefined);
        });

        it('Should return undefined if input2 is not number', () => {
            assert(mathEnforcer.sum(10, 'something') === undefined);
        });

        it('Should return undefined if both input is not number', () => {
            assert(mathEnforcer.sum('something', 'something') === undefined);
        });

        it('Should return right answer if input1 and input2 are numbers', () => {
            assert(mathEnforcer.sum(10, 5) === 15);
        });

        it('Should return right answer if input1 is negative, input2 positive', () => {
            assert(mathEnforcer.sum(-5, 15) === 10);
        });

        it('Should return right answer if input1 is positive, input2 is negative', () => {
            assert(mathEnforcer.sum(5, -15) === -10);
        });

        it('Should return right answer if both input is negative', () => {
            assert(mathEnforcer.sum(-5, -15) === -20);
        });

        it('Should return right answer if input1 and input2 are decimal numbers', () => {
            assert(mathEnforcer.sum(5.5, 4.5) === 10);
        });

        it('Should return right answer if input1 is decimal number', () => {
            assert(mathEnforcer.sum(5.5, 5) === 10.5);
        });

    });

});