let { expect } = require('chai');

let { assert } = require('chai');

let { cinema } = require('./cinema.js');


describe("Tests for cinema", function () {
    describe("Test showMovies", function () {
        it("Should return message when array is zero", function () {
            let inputArr = [];
            expect(cinema.showMovies(inputArr)).to.equal('There are currently no movies to show.');
        });

        it("Should return array elements separated by comma and space", function () {
            let inputArr = ['King Kong', 'The Tomorrow War', 'Joker'];
            expect(cinema.showMovies(inputArr)).to.equal('King Kong, The Tomorrow War, Joker');
        });
    });

    describe("Test ticketPrice", function () {
        it("Should return correct price 12.00 when projection type is Premiere", function () {
            expect(cinema.ticketPrice('Premiere')).to.equal(12.00);
        });

        it("Should return correct price 7.50 when projection type is Normal", function () {
            expect(cinema.ticketPrice('Normal')).to.equal(7.50);
        });

        it("Should return correct price 5.50 when projection type is Discount", function () {
            expect(cinema.ticketPrice('Discount')).to.equal(5.50);
        });

        it("Should return error when input is not present in schedule", function () {
            expect(() => cinema.ticketPrice('Bad News')).to.throw(Error, 'Invalid projection type.');
        });
    });

    describe("Test swapSeatsInHall", function () {
        it("Should return message when one of the parameters do not exist", function () {
            expect(cinema.swapSeatsInHall(5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 1st is not integer", function () {
            expect(cinema.swapSeatsInHall({pepi:"pepi"}, 5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 2nd is not integer", function () {
            expect(cinema.swapSeatsInHall(5, '1.65')).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 1st is bigger than 20", function () {
            expect(cinema.swapSeatsInHall(30, 5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 2nd is bigger than 20", function () {
            expect(cinema.swapSeatsInHall(5, 30)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 1st is less than 0", function () {
            expect(cinema.swapSeatsInHall(-10, 5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 2nd is less than 0", function () {
            expect(cinema.swapSeatsInHall(5, -10)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 1st is equal to 0", function () {
            expect(cinema.swapSeatsInHall(0, 5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 2nd is equal to 0", function () {
            expect(cinema.swapSeatsInHall(5, 0)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return message when 1st and 2nd are equal", function () {
            expect(cinema.swapSeatsInHall(5, 5)).to.equal('Unsuccessful change of seats in the hall.');
        });

        it("Should return successful message", function () {
            expect(cinema.swapSeatsInHall(7, 8)).to.equal('Successful change of seats in the hall.');
        });

    });
});


