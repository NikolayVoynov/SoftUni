var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Melon = /** @class */ (function () {
    function Melon(weight, melonSort) {
        this.weight = weight;
        this.melonSort = melonSort;
    }
    return Melon;
}());
var Watermelon = /** @class */ (function (_super) {
    __extends(Watermelon, _super);
    function Watermelon(weight, melonSort) {
        return _super.call(this, weight, melonSort) || this;
    }
    Watermelon.prototype.getElementIndex = function () {
        return this.weight * this.melonSort.length;
    };
    Watermelon.prototype.toString = function () {
        console.log('Element: Water');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    };
    return Watermelon;
}(Melon));
var Firemelon = /** @class */ (function (_super) {
    __extends(Firemelon, _super);
    function Firemelon(weight, melonSort) {
        return _super.call(this, weight, melonSort) || this;
    }
    Firemelon.prototype.getElementIndex = function () {
        return this.weight * this.melonSort.length;
    };
    Firemelon.prototype.toString = function () {
        console.log('Element: Fire');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    };
    return Firemelon;
}(Melon));
var Earthmelon = /** @class */ (function (_super) {
    __extends(Earthmelon, _super);
    function Earthmelon(weight, melonSort) {
        return _super.call(this, weight, melonSort) || this;
    }
    Earthmelon.prototype.getElementIndex = function () {
        return this.weight * this.melonSort.length;
    };
    Earthmelon.prototype.toString = function () {
        console.log('Element: Earth');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    };
    return Earthmelon;
}(Melon));
var Airmelon = /** @class */ (function (_super) {
    __extends(Airmelon, _super);
    function Airmelon(weight, melonSort) {
        return _super.call(this, weight, melonSort) || this;
    }
    Airmelon.prototype.getElementIndex = function () {
        return this.weight * this.melonSort.length;
    };
    Airmelon.prototype.toString = function () {
        console.log('Element: Air');
        console.log('Sort: ' + this.melonSort);
        console.log('Element Index: ' + this.getElementIndex());
    };
    return Airmelon;
}(Melon));
