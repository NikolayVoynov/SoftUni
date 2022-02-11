(function solve() {

    Array.prototype.last = function () {
        return this[this.length - 1];
    }

    Array.prototype.skip = function (n) {
        if (n < 0 || n >= this.length) {
            throw new Error('Parameter out of bounderies!')
        }

        let resultArray = [];
        for (let i = n; i < this.length; i++) {
            resultArray.push(this[i]);
        }

        return resultArray;
    }


    Array.prototype.take = function (n) {
        if (n < 0 || n >= this.length) {
            throw new Error('Parameter out of bounderies!')
        }

        let resultArray = [];
        for (let i = 0; i < n; i++) {
            resultArray.push(this[i]);
        }

        return resultArray;
    }

    Array.prototype.sum = function () {
        let sum = 0;
        for (let i = 0; i < this.length; i++) {
            sum += this[i];
        }

        return sum;
    }

    Array.prototype.average = function () {

        return this.sum() / this.length;
    }

})();


