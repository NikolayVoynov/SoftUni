"use strict";
exports.__esModule = true;
var ticket_1 = require("./ticket");
function processTickets(t, sortCrit) {
    var result = [];
    for (var _i = 0, t_1 = t; _i < t_1.length; _i++) {
        var data = t_1[_i];
        var args = data.split("|");
        var destination = args[0], price = args[1], status_1 = args[2];
        result.push(new ticket_1["default"](destination, Number(price), status_1));
    }
    switch (sortCrit) {
        case "destination":
            result = result.sort(function (a, b) { return a.destination.localeCompare(b.destination); });
            break;
        case "price":
            result = result.sort(function (a, b) { return a.price - b.price; });
            break;
        case "status":
            result = result.sort(function (a, b) { return a.status.localeCompare(b.status); });
            break;
    }
    return result;
}
var sortedDest = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
], "destination");
var sortedStatus = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
], "status");
var sortedPrice = processTickets([
    "Philadelphia|94.20|available",
    "New York City|95.99|available",
    "New York City|95.99|sold",
    "Boston|126.20|departed",
], "price");
console.log("--------------");
console.log(sortedDest);
console.log("--------------");
console.log(sortedStatus);
console.log("--------------");
console.log(sortedPrice);
console.log("--------------");
