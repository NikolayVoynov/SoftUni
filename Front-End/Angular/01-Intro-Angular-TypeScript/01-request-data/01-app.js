"use strict";
exports.__esModule = true;
var request_data_1 = require("./request-data");
var Data = new request_data_1["default"]("GET", "http://google.com", "HTTP/1.1", "");
console.log(Data);
