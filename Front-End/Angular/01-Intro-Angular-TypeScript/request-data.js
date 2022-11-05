var RequestData = /** @class */ (function () {
    function RequestData(method, uri, version, message) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
        this.response = undefined;
        this.fulfilled = false;
    }
    return RequestData;
}());
var data = new RequestData('GET', 'http://google.com', 'HTTP/1.1', '');
console.log(data);
