"use strict";
exports.__esModule = true;
var people_1 = require("./people");
var junior = new people_1.Junior("Dexter", 25);
var senior = new people_1.Senior("Mike", 31);
var manager = new people_1.Manager("John", 34);
junior.salary = 2000;
junior.work();
junior.collectSalary();
senior.salary = 4000;
for (var i = 1; i <= 4; i++) {
    senior.work();
}
senior.collectSalary();
manager.salary = 4000;
manager.divident = 800;
for (var i = 1; i <= 3; i++) {
    manager.work();
}
manager.collectSalary();
