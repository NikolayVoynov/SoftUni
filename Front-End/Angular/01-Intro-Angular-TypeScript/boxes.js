var Box = /** @class */ (function () {
    function Box() {
        this.boxes = [];
    }
    Box.prototype.add = function (element) {
        this.boxes.push(element);
    };
    Box.prototype.remove = function () {
        this.boxes.pop();
    };
    Box.prototype.count = function () {
        return this.boxes.length;
    };
    return Box;
}());



